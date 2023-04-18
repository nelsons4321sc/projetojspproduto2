<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
    <!-- PARA USAR O JSTL, o mesmo trabalha com coteúdo dinâmico, abre as tabelas ao abrir a página -->   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>



  <body>
  <!-- Pre-loader start -->
  <jsp:include page="theme-loader.jsp"></jsp:include>
  
  <div id="pcoded" class="pcoded">
      <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">
 		 <jsp:include page="navBarconta.jsp"></jsp:include>

          <div class="pcoded-main-container">
              <div class="pcoded-wrapper">
        		
        		<jsp:include page="navBarMainMenuConta.jsp"></jsp:include>
        		
                  <div class="pcoded-content">
                     
                      <!-- Page-header start -->
                     <jsp:include page="page-headerConta.jsp"></jsp:include>
                      <!-- Page-header end -->
                        <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body" >
                                       
                                        <div class="card" align="center">	
                                          
                                          
                                          
                                          
                                           
                                                            
                                        </div>
                                    </div>
                                    <!-- Page-body end -->
                                </div>
                                <div id="styleSelector"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Required Jquery -->
    <jsp:include page="javaScriptFile.jsp"></jsp:include>
    
    </body>

</html>

    