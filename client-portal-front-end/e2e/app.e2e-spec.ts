import { CustomerPortalFrontEndPage } from './app.po';

describe('customer-portal-front-end App', () => {
  let page: CustomerPortalFrontEndPage;

  beforeEach(() => {
    page = new CustomerPortalFrontEndPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
