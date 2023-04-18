<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
            <nav class="navbar header-navbar pcoded-header">
              <div class="navbar-wrapper">
                  <div class="navbar-logo">
                      <a class="mobile-menu waves-effect waves-light" id="mobile-collapse" href="#!">
                          <i class="ti-menu"></i>
                      </a>
                      <div class="mobile-search waves-effect waves-light">
                          <div class="header-search">
                              <div class="main-search morphsearch-search">
                                  <div class="input-group">
                                      <span class="input-group-addon search-close"><i class="ti-close"></i></span>
                                      <input type="text" class="form-control" placeholder="Enter Keyword">
                                      <span class="input-group-addon search-btn"><i class="ti-search"></i></span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      
                      <a >
                          <img width="40px" class="img-fluid" src="<%= request.getContextPath() %>/assets/images/leao.png" alt="Projeto inicial" />
                      </a>
                      <a class="mobile-options waves-effect waves-light">
                          <i class="ti-more"></i>
                      </a>
                      
                      
                      
                      
                      
                      
                      
                      
                      
                  </div>
                
                  <div class="navbar-container container-fluid">
                      <ul class="nav-left">
                          <li>
                              <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
                          </li>
                          <li class="header-search">
                              <div class="main-search morphsearch-search">
                                  <div class="input-group">
                                      <span class="input-group-addon search-close"><i class="ti-close"></i></span>
                                      <input type="text" class="form-control">
                                      <span class="input-group-addon search-btn"><i class="ti-search"></i></span>
                                  </div>
                              </div>
                          </li>
                          <li>
                              <a href="#!" onclick="javascript:toggleFullScreen()" class="waves-effect waves-light">
                                  <i class="ti-fullscreen"></i>
                              </a>
                          </li>
                      </ul>
                      <ul class="nav-right">
                          <li class="header-notification">
                              <a href="#!" class="waves-effect waves-light">
                              <img width="40px" class="img-fluid" src="<%= request.getContextPath() %>/assets/images/leao.png" alt="Projeto inicial" />
                                  
                              </a>
                              <ul class="show-notification">
                                  <li>
                                      <h6>Novidades</h6>
                                      <label class="label label-danger">Novo</label>
                                  </li>
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                         <!--  <img class="d-flex align-self-center img-radius" src="<%= request.getContextPath() %>/assets/images/avatar-2.jpg" alt="Generic placeholder image"> -->
                                          <div class="media-body">
                                              `<!--  <h5 class="notification-user"><%= request.getSession().getAttribute("usuario") %></h5>-->
                                              <h5 align="center" >Provérbios 3.5</h5>
                                              <p align="center" class="notification-msg">Confia no Senhor de todo o teu coração e não te estribes no teu próprio entendimento</p>
                                             <!--   <span class="notification-time">30 minutes ago</span> -->
                                          </div>
                                      </div>
                                  </li>
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                          <!--   <img class="d-flex align-self-center img-radius" src="<%= request.getContextPath() %>/assets/images/nelson.jpg" alt="Generic placeholder image"> -->
                                          <div class="media-body">
                                              <h5 align="center" class="notification-user">Provérbios 3.7</h5>
                                              <p align="center" class="notification-msg">Não Seja sábios aos teus próprios olhos tema ao Senhor e aparta-te do mal</p>
                                            
                                          </div>
                                      </div>
                                  </li>
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                          <img class="d-flex align-self-center img-radius" src="<%= request.getContextPath() %>/assets/images/avatar-3.jpg" alt="Generic placeholder image">
                                          <div class="media-body">
                                              <h5 class="notification-user">Sara Soudein</h5>
                                              <p class="notification-msg">Lorem ipsum dolor sit amet, consectetuer elit.</p>
                                              <span class="notification-time">30 minutes ago</span>
                                          </div>
                                      </div>
                                  </li>
                              </ul>
                          </li>
                      </ul>
                  </div>
              </div>
          </nav>