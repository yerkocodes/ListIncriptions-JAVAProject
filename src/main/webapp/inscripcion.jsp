<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
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
					<li class="nav-item"><a class="nav-link" href="preinscripcion">Agregar inscripcion</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Listar inscripciones</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Seccion Formulario ingreso valores -->
	<section class="container">
		<form action="posInscripcion" method="post">
			<div class="mb-3">
				<label for="exampleInputNombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="exampleInputNombre"
					name="nombre" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputTelefono" class="form-label">Telefono</label>
				<input type="text" class="form-control" id="exampleInputTelefono"
					name="telefono" required>
			</div>
			<div class="mb-3">
				<select name="idCurso" required>
					<c:forEach items="${listaCursos}" var="temp">
						<!-- forEach(CursoDTO temp : listaCursos) -->
						<option value="${temp.getId_curso()}">
							<c:out value="${temp.getDescripcion()}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<select name="idFormaPago" required>
					<c:forEach items="${listaFormasPago}" var="temp">
						<!-- forEach(FormaPaoDTO temp : listaFormasPago) -->
						<option value="${temp.getId_forma_pago()}">
							<c:out value="${temp.getDescripcion()}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</section>


	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>