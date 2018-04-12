package com.medgenome.clientportal.config;

import static com.medgenome.clientportal.model.Constants.HEADER_STRING;
import static com.medgenome.clientportal.model.Constants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.medgenome.clientportal.service.impl.MyUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);
		String usernameRole = null;
		String authToken = null;
		UserDetails userDetails = null;
		String role = null;
		String userName = null;
		boolean isError = false;
		boolean isValidtoken = false;
		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replace(TOKEN_PREFIX, "");
			try {
				usernameRole = jwtTokenUtil.getUsernameFromToken(authToken);
				role = getRoleFromJwtString(usernameRole);
				userName = getUserNameFromJwtString(usernameRole);
				userDetails = User.withUsername(userName).password("dummy").roles(role).build();
				isValidtoken = jwtTokenUtil.validateToken(authToken, userDetails);
				if (!isValidtoken) {
					isError = true;
					sendError(401, "Authentication Failed. Username or Password not valid.", res);
				}
				// StringBuffer url = req.getRequestURL();
				// String uri = req.getRequestURI();
				// String host = url.substring(0, url.indexOf(uri)); //result

				// System.out.println("getRemoteHost : "+req.getRemoteHost());
				// System.out.println("getRemoteAddr : "+req.getRemoteAddr());
				// System.out.println("getRemotePort : "+req.getRemotePort());

			} catch (IllegalArgumentException e) {
				logger.error("an error occured during getting username from token", e);
				isError = true;
				sendError(401, "An error occured during getting username from token.", res);

			} catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
				isError = true;
				sendError(401, "The token is expired and not valid anymore.", res);
			} catch (SignatureException e) {
				logger.error("Authentication Failed. Username or Password not valid.");
				isError = true;
				sendError(401, "Authentication Failed. Username or Password not valid.", res);
			} catch (Exception e) {
				logger.error("Authentication Failed. Username or Password not valid.");
				isError = true;
				sendError(401, "Authentication Failed. Username or Password not valid.", res);
			}
		} else {
			logger.warn("couldn't find bearer string, will ignore the header");
		}
		if (!isError && (usernameRole != null && SecurityContextHolder.getContext().getAuthentication() == null)) {
			// SecurityContext sec = SecurityContextHolder.getContent();
			// AbstractAuthenticationToken auth =
			// (AbstractAuthenticationToken)sec.getAuthentication();
			// HashMap<String, Object> info = new HashMap<String, Object>();
			// info.put("companyId", 42);
			// auth.setDetails(info);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, Arrays.asList(new SimpleGrantedAuthority(role)));
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
			logger.info("authenticated user " + usernameRole + ", setting security context");
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtTokenUtil.generateToken(usernameRole);
			res.setHeader("jwt", token);
		}
		if (!isError) {
			chain.doFilter(req, res);
		}
	}

	private void sendError(int httpStatus, String message, HttpServletResponse res) throws IOException {
		res.sendError(httpStatus, message);
	}

	private String getRoleFromJwtString(String jwtUserRolestring) {
		String[] authArr = jwtUserRolestring.split(":");
		String role = null;
		if (authArr != null && authArr.length > 1) {
			role = authArr[1].split("_")[1];
		}
		return role;
	}

	private String getUserNameFromJwtString(String jwtUserRolestring) {
		String[] authArr = jwtUserRolestring.split(":");
		String userName = null;
		if (authArr != null && authArr.length > 0) {
			userName = authArr[0];
		}
		return userName;
	}
}