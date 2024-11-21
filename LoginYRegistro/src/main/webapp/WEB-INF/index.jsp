<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN Y REGISTRO</title>
</head>
<body>
	<h1>Login y Registro</h1>
	    <div>
	        <!-- Formulario de Registro -->
	        <div>
	            <h2>Registro</h2>
	            <form:form action="/procesa/registro" modelAttribute="usuario" method="POST">
	                <div>
	                    <label for="nombreUsuario">Nombre de Usuario:</label>
	                    <form:input path="nombreUsuario" />
	                    <form:errors path="nombreUsuario" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="password">Contraseña:</label>
	                    <form:password path="password" />
	                    <form:errors path="password" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="confirmacionPassword">Confirmar Contraseña:</label>
	                    <form:password path="confirmacionPassword" />
	                    <form:errors path="confirmacionPassword" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="correo">Correo Electrónico:</label>
	                    <form:input path="correo" />
	                    <form:errors path="correo" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="nombre">Nombre:</label>
	                    <form:input path="nombre" />
	                    <form:errors path="nombre" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="apellido">Apellido:</label>
	                    <form:input path="apellido" />
	                    <form:errors path="apellido" cssClass="error-message" />
	                </div>
	                <div>
	                    <label for="fechaDeNacimiento">Fecha de Nacimiento:</label>
	                    <form:input path="fechaDeNacimiento" type="date" />
	                    <form:errors path="fechaDeNacimiento" cssClass="error-message" />
	                </div>
	                <div>
	                    <button type="submit">Registrarse</button>
	                </div>
	            </form:form>
	        </div>
	
	        <!-- Formulario de Login -->
	        <div>
	            <h2>Login</h2>
	            <form action="/procesa/login" method="POST">
	                <div>
	                    <label for="nombreUsuario">Nombre de Usuario:</label>
	                    <input type="text" name="nombreUsuario" />
	                </div>
	                <div>
	                    <label for="password">Contraseña:</label>
	                    <input type="password" name="password" />
	                    <c:if test="${not empty loginError}">
	                        <span class="error-message">${loginError}</span>
	                    </c:if>
	                </div>
	                <div>
	                    <button type="submit">Iniciar Sesión</button>
	                </div>
	            </form>
	        </div>
	    </div>
</body>
</html>