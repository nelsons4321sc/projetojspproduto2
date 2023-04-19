<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    


    
   

    
              <nav class="pcoded-navbar">
                      <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
                      <div class="pcoded-inner-navbar main-menu">
                          <div class="">
                              <div class="main-menu-header">
                              
                              
								<c:if test="${imagemUser != '' && imagemUser != null}">			                              
                                  <img class="img-80 img-radius" src=" ${imagemUser}"  alt="User-Profile-Image">
                                 </c:if>
                                 
                                 <c:if test="${imagemUser == '' || imagemUser == null}">			                              
                                  <img class="img-80 img-radius" src="<%= request.getContextPath() %>/assets/images/nelson.jpg" alt="User-Profile-Image">
                                 </c:if>
                                  <div class="user-details">
                                      <span id="more-details"><%= session.getAttribute("usuario") %><i class="fa fa-caret-down"></i></span>
                                  </div>
                              </div>
        
                              <div class="main-menu-content">
                                  <ul>
                                      <li class="more-details">
                                          <!--  <a href="user-profile.html"><i class="ti-user"></i>View Profile</a>-->
                                          <!--  <a href="#!"><i class="ti-settings"></i>Settings</a> -->
                                          <a href="<%= request.getContextPath() %>/ServletLogin?acao=logout"><i class="ti-layout-sidebar-left"></i>Sair</a>
                                      </li>
                                  </ul>
                              </div>
                          </div>
                          
                                               
                          <ul class="pcoded-item pcoded-left-item">
                              <li class="active">
                                  <a href="#" class="waves-effect waves-dark" style="margin-top: 15px">
                                      <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                                      <span class="pcoded-mtext" data-i18n="nav.dash.main">Produtos</span>
                                      <span class="pcoded-mcaret"></span>
                                  </a>
                              </li>
                              
                              
                              <li class="pcoded-hasmenu">
                                  <a href="javascript:void(0)" class="waves-effect waves-dark">
                                      <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                                      <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">Cadastro</span>
                                      <span class="pcoded-mcaret"></span>
                                  </a>
                                  <ul class="pcoded-submenu">
                                      
                                      <li class=" ">
                                          <a href="<%= request.getContextPath() %>/ServletProdutoController?acao=listarProduto" class="waves-effect waves-dark">
                                              <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                            
                                           <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Produtos</span>
                                              <span class="pcoded-mcaret"></span>
                                          </a>
                                      </li>
                                
                                    
                                      
                                    
                                  </ul>
                              </li>
                              
                              <li class="pcoded-hasmenu">
                                  <a href="javascript:void(0)" class="waves-effect waves-dark">
                                      <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                                      <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">Lista</span>
                                      <span class="pcoded-mcaret"></span>
                                  </a>
                                  <ul class="pcoded-submenu">
                                      
                                      <li class=" ">
                                          <a href="<%= request.getContextPath() %>/ServletUsuarioController?acao=listarTabUser" class="waves-effect waves-dark">
                                              <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                              <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Produtos</span>
                                              <span class="pcoded-mcaret"></span>
                                          </a>
                                      </li>
                                 
                                      
                                    
                                  </ul>
                              </li>
                              
                              
                          </ul>
                          
                            
                        <div class="pcoded-navigation-label" data-i18n="nav.category.forms" style="color: green">Relatórios</div>
                        
                          <ul class="pcoded-item pcoded-left-item">
                              
                              <li >
                                  <a href="<%= request.getContextPath() %>/principal/reluser.jsp" class="waves-effect waves-dark" style="margin-top: 15px">
                                      <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                                      <span class="pcoded-mtext" >Produtos</span>
                                      <span class="pcoded-mcaret"></span>
                                  </a>
                              </li> 
                              
                              <li>
                                  <a href="<%=request.getContextPath() %>/principal/relusergrafico.jsp" class="waves-effect waves-dark">
                                      <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                                      <span class="pcoded-mtext"  data-i18n="nav.form-components.main">Gráfico Produtos</span>
                                      <span class="pcoded-mcaret"></span>
                                  </a>
                              </li>
                           </ul>
        				
        				
        				
                      </div>
              
                      
                  </nav>
                        
	              