<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listar Inscripciones</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<!-- Java Standard Tag Library JSTL -->
	<!-- https://www.baeldung.com/jstl -->

	<!-- Barra de navegacion -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Listar Inscripciones</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="preinscripcion">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="preinscripcion">Agregar
							inscripcion</a></li>
					<li class="nav-item"><a class="nav-link" href="preListarinscripciones">Listar
							inscripciones</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Seccion Lista Inscripciones -->
	<section class="container my-5">
		<table class="table">
			<thead>
				<tr>
					<th class="text-center" scope="col">ID</th>
					<th class="text-center" scope="col">NOMBRE</th>
					<th class="text-center" scope="col">TELEFONO</th>
					<th class="text-center" scope="col">ID CURSO</th>
					<th class="text-center" scope="col">ID FORMA PAGO</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ listaInscripciones }" var="temp">
				<tr>
					<td><c:out value="${temp.getId_inscripcion() }"></c:out></td>
					<td><c:out value="${temp.getNombre() }"></c:out></td>
					<td><c:out value="${temp.getTelefono() }"></c:out></td>
					<td><c:out value="${temp.getId_curso() }"></c:out></td>
					<td><c:out value="${temp.getId_forma_pago() }"></c:out></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>


	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>