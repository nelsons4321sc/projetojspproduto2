<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
            <nav class="navbar header-navbar pcoded-header">
              <div class="navbar-wrapper">
                  <div class="navbar-logo">
                      <a class="mobile-menu waves-effect waves-light" id="mobile-collapse" href="#!">
                          <i class="ti-menu"></i>
                      </a>
                      <!-- 
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
                       -->
                      <a class="mobile-options waves-effect waves-light">
                          <i class="ti-more"></i>
                      </a>
                      
                  </div>
                
                  <div class="navbar-container container-fluid">
                      <ul class="nav-left">
                          <li>
                              <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
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
                                  
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                         
                                          <div class="media-body">
                                              `<!--  <h5 class="notification-user"><%= request.getSession().getAttribute("usuario") %></h5>-->
                                              <h5 align="center" class="notification-user" >PROV�RBIOS 3.5</h5>
                                              <p align="center" class="notification-msg">Confia no SENHOR de todo o teu cora��o e n�o te estribes no teu pr�prio entendimento</p>
                                             <!--   <span class="notification-time">30 minutes ago</span> -->
                                          </div>
                                      </div>
                                  </li>
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                          <!--   <img class="d-flex align-self-center img-radius" src="<%= request.getContextPath() %>/assets/images/nelson.jpg" alt="Generic placeholder image"> -->
                                          <div class="media-body">
                                              <h5 align="center" class="notification-user">PROV�RBIOS 3.7</h5>
                                              <p align="center" class="notification-msg">N�o Seja s�bios aos teus pr�prios olhos tema ao SENHOR e aparta-te do mal</p>
                                            
                                          </div>
                                      </div>
                                  </li>
                                  <li class="waves-effect waves-light">
                                      <div class="media">
                                           <div class="media-body">
                                              <h5 align="center" class="notification-user">SALMOS 46.10</h5>
                                              <p align="center" class="notification-msg">Aquietai-vos e sabei eu sou DEUS; sou exaltado entre as na��es, sou exaltado na terra</p>
                                              
                                          </div>
                                      </div>
                                  </li>
                                  <li class="more-details">
                                          <!--  <a href="user-profile.html"><i class="ti-user"></i>View Profile</a>-->
                                          <!--  <a href="#!"><i class="ti-settings"></i>Settings</a> -->
                                          <a href="<%= request.getContextPath() %>/ServletLogin?acao=logout"><i class="ti-layout-sidebar-left"></i>Sair</a>
                                  </li>
                              </ul>
                          </li>
                      </ul>
                  </div>
              </div>
          </nav>