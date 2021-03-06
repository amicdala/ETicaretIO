package org.apache.jsp.Zeon_0020Files;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.DataAccessObject.MusteriDAO;
import DataBase.DataTransferObject.Musteri;

public final class kayitol_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    String ad = request.getParameter("ad");
    String loginEposta = request.getParameter("login-eposta");
    String mesaj = "bilgileri giriniz";

    if (loginEposta != null) {
        String loginPassword = request.getParameter("login-password");
        MusteriDAO musteriDAO = new MusteriDAO();
        boolean sonuc = musteriDAO.musteriLogin(loginEposta, loginPassword);

        if (sonuc) {
            Musteri musteri = musteriDAO.musteriByEposta(loginEposta);

            session.setAttribute("userMail", loginEposta);
            String don = (String) session.getValue("don");
            if (don != null) {
                response.sendRedirect(don);
            }

            if (musteri.getId() == 1) {
                response.sendRedirect("../../ETicaretIO/template_content/index.jsp");
            } else {
                response.sendRedirect("urunler.jsp");
            }
        } else {
            mesaj = "bilgileri kontrol ediniz";
        }

    }

    if (ad != null) {
        String sifre = request.getParameter("password");
        String sifreTekrar = request.getParameter("password1");
        if (sifre.equals(sifreTekrar)) {
            String soyad = request.getParameter("soyad");
            String email = request.getParameter("email");
            String adres = request.getParameter("adres");
            String telefon = request.getParameter("telefon");

            Musteri musteri = new Musteri(0, ad, soyad, email, telefon, adres, sifre);
            MusteriDAO musteriDAO = new MusteriDAO();
            musteriDAO.insert(musteri);
            mesaj = "Bilgiler kaydedildi giris yapiniz";
            response.sendRedirect("kayitol.jsp");

        } else {
            mesaj = "sifre ve sifre tekrar birbiriyle uyusmuyor";
        }
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("    <title>Zeon</title>\n");
      out.write("    <meta name=\"description\" content=\"Here goes description\" />\n");
      out.write("    <meta name=\"author\" content=\"author name\" />\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\" />\n");
      out.write("    <!-- ======================================================================\n");
      out.write("                                Mobile Specific Meta\n");
      out.write("    ======================================================================= -->\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n");
      out.write("    <!-- ======================================================================\n");
      out.write("                                Style CSS + Google Fonts\n");
      out.write("    ======================================================================= \n");
      out.write("    <link href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,400italic,700italic,400,600,700,800\" rel=\"stylesheet\" type=\"text/css\"> -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.css\" />    \n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- ======================================================================\n");
      out.write("                                    START SCRIPTS\n");
      out.write("    ======================================================================= -->\n");
      out.write("<div class=\"header\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"header-top-info\">\n");
      out.write("            <ul class=\"header-top-socials\">\n");
      out.write("                <li><a href=\"#\"><i class=\"icon-160\" title=\"161\"></i></a></li>\n");
      out.write("                <li><a href=\"#\"><i class=\"icon-138\" title=\"161\"></i></a></li>\n");
      out.write("                <li><a href=\"#\"><i class=\"icon-106\" title=\"161\"></i></a></li>\n");
      out.write("                <li><a href=\"#\"><i class=\"icon-169\" title=\"161\"></i></a></li>\n");
      out.write("                <li><a href=\"#\"><i class=\"icon-163\" title=\"161\"></i></a></li>\n");
      out.write("            </ul>\n");
      out.write("            Phone: +373 56 65 65\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header-middle-info\">\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\">\n");
      out.write("                        <img src=\"images/elements/logo.png\" alt=\"site logo\" />\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <ul class=\"header-middle-account\">\n");
      out.write("                    <li><a href=\"cart.html\"><i class=\"icon-330\" title=\"My account\"></i> Kullanıcı Hesabı</a></li>\n");
      out.write("                    <li><a href=\"register.html\"><i class=\"icon-351\" title=\"Login\"></i> Giriş Yap</a></li>\n");
      out.write("                    <li><a href=\"#\">TL</a></li>\n");
      out.write("                    <li><a href=\"checkout.html\"><i class=\"icon-259\" title=\"Checkout\"></i> Sepet</a></li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <form action=\"index.jsp\">\n");
      out.write("                            <input type=\"submit\" name=\"exit\" value=\"Çıkış Yap\"></input>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"clear\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <div class=\"search-cart\">\n");
      out.write("                <form class=\"search\">\n");
      out.write("                    <input type=\"text\" class=\"search-line\" placeholder=\"Search\" name=\"serch\" />\n");
      out.write("                    <input type=\"submit\" value=\"\" class=\"search-button\" />\n");
      out.write("                </form>\n");
      out.write("                <div class=\"cart-all\">\n");
      out.write("                    <i class=\"icon-19\" title=\"19\"></i>TL (234)\n");
      out.write("                    <div class=\"inside-cart\">\n");
      out.write("                        <p>Alışveriş Sepetinde 2 ürün</p>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"inside-cart-image\"><img src=\"images/photos/image-9.jpg\" alt=\"product name\" /></div>\n");
      out.write("                                <button>x</button>\n");
      out.write("                                <a href=\"product.html\">Alınan ürün</a>\n");
      out.write("                                <p>Adet Fiyatı 50TL</p>\n");
      out.write("                                <p>Adet: 1</p>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"inside-cart-image\"><img src=\"images/photos/image-8.jpg\" alt=\"product name\" /></div>\n");
      out.write("                                <button>x</button>\n");
      out.write("                                <a href=\"product.html\">Alınan Ürün</a>\n");
      out.write("                                <p>Adet Fiyatı 75TL</p>\n");
      out.write("                                <p>Adet: 2</p>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"repsonsive-menu\"><i class=\"icon-406\" title=\"406\"></i> Menu</div>\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"menu-item-has-children\"><a href=\"index.jsp\">Anasayfa</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"all-products.html\">Kategoriler</a></li>\n");
      out.write("                <li class=\"active\"><a href=\"all-products.html\">Alışveriş</a></li>\n");
      out.write("                <li class=\"menu-item-has-children\"><a href=\"blog.html\">Blog</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li><a href=\"contact.html\">İletişim</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"clear\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- ======================================================================\n");
      out.write("                                END HEADER\n");
      out.write("======================================================================= -->  \n");
      out.write("\n");
      out.write("<!-- ======================================================================\n");
      out.write("                                START CONTENT\n");
      out.write("======================================================================= -->\n");
      out.write("<div class=\"content\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"site-title\"><div class=\"site-inside\"><span>Çıkış</span></div></div> \n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"forms-separation\">\n");
      out.write("                    <div class=\"login-form-box\">\n");
      out.write("                        ");
      out.print(mesaj);
      out.write("\n");
      out.write("                        <form class=\"login-form\" action=\"kayitol.jsp\">\n");
      out.write("                            <h3>login now</h3>\n");
      out.write("                            <p>E-mail</p>\n");
      out.write("                            <input type=\"text\" name=\"login-eposta\" class=\"login-line\">\n");
      out.write("                                <p>Password</p>\n");
      out.write("                                <input type=\"password\" name=\"login-password\" class=\"login-line\">\n");
      out.write("                                    <input type=\"submit\" value=\"Login\" class=\"button-6\">\n");
      out.write("\n");
      out.write("                                        </form>\n");
      out.write("                                        </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <form class=\"register-form\" action=\"kayitol.jsp\">\n");
      out.write("                                                <h3>Kayit ol <br>");
      out.print( mesaj);
      out.write(" </h3>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"col-md-6\">\n");
      out.write("                                                        <p>Adınız <span class=\"neccesary\">*</span></p>\n");
      out.write("                                                        <input type=\"text\" name=\"ad\" class=\"input-line\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-md-6\">\n");
      out.write("                                                        <p>Soyadınız<span class=\"neccesary\">*</span></p>\n");
      out.write("                                                        <input type=\"text\" name=\"soyad\" class=\"input-line\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <p>E-mail e<span class=\"neccesary\">*</span></p>\n");
      out.write("                                                <input type=\"text\" name=\"email\" class=\"input-line\">\n");
      out.write("                                                    <div class=\"row\">\n");
      out.write("                                                        <div class=\"col-md-6\">\n");
      out.write("                                                            <p>Sıfre <span class=\"neccesary\">*</span></p>\n");
      out.write("                                                            <input type=\"password\" name=\"password\" class=\"input-line\">\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-md-6\">\n");
      out.write("                                                            <p>Sıfre Tekrar<span class=\"neccesary\">*</span></p>\n");
      out.write("                                                            <input type=\"password\" name=\"password1\" class=\"input-line\">\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <p>Address <span class=\"neccesary\">*</span></p>\n");
      out.write("                                                    <input type=\"text\" name=\"adres\" class=\"input-line\">\n");
      out.write("                                                        <p>Telegon <span class=\"neccesary\">*</span></p>\n");
      out.write("                                                        <input type=\"text\" name=\"telefon\" class=\"input-line\">\n");
      out.write("\n");
      out.write("                                                            <input type=\"submit\"/>\n");
      out.write("\n");
      out.write("                                                            </form>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"clear\"></div>\n");
      out.write("                                                            <div class=\"col-md-12\">\n");
      out.write("                                                                <div class=\"order-title\">Siparişleriniz</div>\n");
      out.write("                                                                <div class=\"row\">\n");
      out.write("                                                                    <div class=\"col-md-9\">\n");
      out.write("                                                                        <ul class=\"checkout-info\">\n");
      out.write("                                                                            <li class=\"checkout-info-1\">Ürün</li>\n");
      out.write("                                                                            <li class=\"checkout-info-2\">Toplam</li>\n");
      out.write("                                                                        </ul>\n");
      out.write("\n");
      out.write("                                                                        <div class=\"checkout-info-box\">\n");
      out.write("                                                                            <!-- REPEAT PRODUCT -->\n");
      out.write("                                                                            <ul class=\"checkout-product\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Bisiklet</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">TL 350</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                            <!-- REPEAT PRODUCT -->\n");
      out.write("                                                                            <ul class=\"checkout-product\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Oyun Konsolu</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">TL 200</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("\n");
      out.write("                                                                            <ul class=\"checkout-product\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Oyun DWD</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">TL 3650</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                            <!-- CART DETAILS -->\n");
      out.write("                                                                            <ul class=\"checkout-product o-last\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Sepet Ara Toplamı</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">TL 4200</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                            <ul class=\"checkout-product o-last\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Kargo</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">Ücretsiz Kargo</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                            <ul class=\"checkout-product last\">\n");
      out.write("                                                                                <li class=\"checkout-product-1\">Diğer Toplam</li>\n");
      out.write("                                                                                <li class=\"checkout-product-2\">TL 4200</li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                            <!-- CART DETAILS -->\n");
      out.write("                                                                        </div>\n");
      out.write("\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"col-md-3\">\n");
      out.write("                                                                        <ul class=\"payment-method\">\n");
      out.write("                                                                            <li><label><input type=\"radio\" id=\"payment_method_bacs\" class=\"input-radio\" name=\"payment_method\" value=\"bacs\" checked=\"checked\"> Banka Havalesi</label></li>\n");
      out.write("                                                                            <li><label><input type=\"radio\" id=\"payment_method_cheque\" class=\"input-radio\" name=\"payment_method\" value=\"cheque\"> Kapıda Ödeme</label></li>\n");
      out.write("                                                                            <li><label><input type=\"radio\" id=\"payment_method_paypal\" class=\"input-radio\" name=\"payment_method\" value=\"paypal\"> Kredi Kartları</label></li>\n");
      out.write("                                                                        </ul>\n");
      out.write("                                                                        <a href=\"#\" class=\"button-6\">Sipariş Vermek</a>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <!-- ======================================================================\n");
      out.write("                                                                                            END CONTENT\n");
      out.write("                                                            ======================================================================= -->\n");
      out.write("\n");
      out.write("                                                            <!-- ======================================================================\n");
      out.write("                                                                                            START FOOTER\n");
      out.write("                                                            ======================================================================= -->\n");
      out.write("                                                            <div class=\"footer\">\n");
      out.write("                                                                <div class=\"container\">\n");
      out.write("                                                                    <div class=\"row\">\n");
      out.write("                                                                        <div class=\"col-md-2 col-xs-6\">\n");
      out.write("                                                                            <ul class=\"socials\">\n");
      out.write("                                                                                <li><a href=\"#\"><img src=\"images/elements/socials/facebook.png\" alt=\"facebook\"/>Facebook</a></li>\n");
      out.write("                                                                                <li><a href=\"#\"><img src=\"images/elements/socials/twitter.png\" alt=\"twitter\"/>Twitter</a></li>\n");
      out.write("                                                                                <li><a href=\"#\"><img src=\"images/elements/socials/youtube.png\" alt=\"youtube\"/>Youtube</a></li>\n");
      out.write("                                                                                <li><a href=\"#\"><img src=\"images/elements/socials/googleplus.png\" alt=\"google\"/>Google+</a></li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <div class=\"col-md-2 col-xs-6\">\n");
      out.write("                                                                            <ul>\n");
      out.write("                                                                                <li><a href=\"#\">Şimdi Kaydol</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Bültene abone olun</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Sipariş</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Teslim</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">İletişim</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Faq</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Sorular</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">İş ortaklarımız</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Hakkımızda</a></li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <div class=\"col-md-2 col-xs-6\">\n");
      out.write("                                                                            <ul>\n");
      out.write("                                                                                <li><a href=\"#\">Ödemeler</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Rehber</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Sipariş izleme</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Sipariş Geçmişi</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">İadeler</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Şartlar ve koşullar</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Güvenlik</a></li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <div class=\"col-md-2 col-xs-6\">\n");
      out.write("                                                                            <ul class=\"menu-item\">\n");
      out.write("                                                                                <li><a href=\"#\">Anasayfa</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Kategoriler</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Alışveriş</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Bolg</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Hakkımızda</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Hizmetler</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">Sepet</a></li>\n");
      out.write("                                                                                <li><a href=\"#\">İletişim</a></li>\n");
      out.write("                                                                            </ul>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <div class=\"col-md-4\">\n");
      out.write("                                                                            <div class=\"subscription\">\n");
      out.write("                                                                                <div class=\"subscription-title\">Bülten abone ol</div>\n");
      out.write("                                                                                <form class=\"subscription\" id=\"newsletter\" method=\"post\">\n");
      out.write("                                                                                    <input type=\"text\" name=\"newsletter-name\" placeholder=\"Name\" class=\"subscription-line\">\n");
      out.write("                                                                                        <input type=\"text\" name=\"newsletter-email\" placeholder=\"E-mail\" class=\"subscription-line\">\n");
      out.write("                                                                                            <input type=\"submit\" value=\"send\" class=\"button-5\">\n");
      out.write("                                                                                                </form>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                <div class=\"container\">\n");
      out.write("                                                                                                    <div class=\"mini-footer\">\n");
      out.write("                                                                                                        <div class=\"row\">\n");
      out.write("                                                                                                            <div class=\"col-md-6\">\n");
      out.write("                                                                                                                Copyright 2013 ZEON &nbsp;  &nbsp;  &nbsp; Designed by <a href=\"http://www.teslathemes.com\">Teslathemes</a>\n");
      out.write("                                                                                                            </div>\n");
      out.write("                                                                                                            <div class=\"col-md-6\">\n");
      out.write("                                                                                                                <div class=\"text-right\">\n");
      out.write("                                                                                                                    <img src=\"images/elements/payment.png\" alt=\"payment systems\" />\n");
      out.write("                                                                                                                </div>\n");
      out.write("                                                                                                            </div>\n");
      out.write("                                                                                                        </div>\n");
      out.write("                                                                                                    </div>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                                <!-- ======================================================================\n");
      out.write("                                                                                                                                END FOOTER\n");
      out.write("                                                                                                ======================================================================= -->\n");
      out.write("\n");
      out.write("                                                                                                <!-- ======================================================================\n");
      out.write("                                                                                                                                START SCRIPTS\n");
      out.write("                                                                                                ======================================================================= -->\n");
      out.write("                                                                                                <script src=\"js/modernizr.custom.63321.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/jquery-1.10.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/placeholder.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/imagesloaded.pkgd.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/masonry.pkgd.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/jquery.swipebox.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/farbtastic/farbtastic.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/options.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <script src=\"js/plugins.js\" type=\"text/javascript\"></script>\n");
      out.write("                                                                                                <!--[if lt IE 9]>\n");
      out.write("                                                                                                  <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("                                                                                                  <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\n");
      out.write("                                                                                                <![endif]-->\n");
      out.write("                                                                                                <!-- ======================================================================\n");
      out.write("                                                                                                                                END SCRIPTS\n");
      out.write("                                                                                                ======================================================================= -->\n");
      out.write("                                                                                                </body>\n");
      out.write("\n");
      out.write("                                                                                                </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
