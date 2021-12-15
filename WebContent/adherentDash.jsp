<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MyClub</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body style="background: #f3f3f3;">
<nav class="navbar navbar-light bg-white justify-content-between">
  <a class="navbar-brand" href="#">
    <img src="img/logos.png" width="50" height="50" class="d-inline-block align-top" alt="Logo">MyClub
  </a>
  <form class="form-inline" action="GerantDash" method="post">
  <input type="hidden" name="btn" value="quit">
    <button class="btn btn-outline-danger my-2 my-sm-0" type="submit"><i class="fas fa-sign-out-alt"></i></button>
  </form>
</nav>
<div class="row">
	<div class="col-sm-2 bg-success">
		<form class="form-inline border-bottom border-dange" action="AdherentDash" method="get">
			<input type="hidden" name="btn" value="profil">
			<button disabled class="readonly btn btn-outline-light btn-lg btn-block mb-4 mt-5 ml-2 mr-2" type="submit"><i class="fas fa-tshirt"></i> Profil</button>		
		</form>
		
		
	</div>
	<div class="col-sm-10" >
		<br>
		
		<br>
		<div class="row">
		<div class="col-sm-4 bg-white ml-4 ">
			<div class="text-center row  d-flex justify-content-center">
			  <img src="img/client.png" class="rounded w-50 p-3" alt="...">
			</div>
			<div class="text-center row"><h3><c:out value="${profil.getNom() }"></c:out></h3></div>
			<div class="text-center row text-muted"><h4><c:out value="${profil.getEmail()}"></c:out></h4></div>
		</div>
		<div class="col-sm-7 bg-white ml-4">
			<div class="row m-4"><h5>Informations</h5></div>
			<div class="row m-4"><div class="col-sm-4">Role</div><div class="col-sm-4 btn btn-outline-success disabled" ><c:out value="${profil.getRole()}"></c:out></div></div>
			<div class="row m-4"><div class="col-sm-4">Age</div><div class="col-sm-4 btn btn-outline-success disabled" ><c:out value="${profil.getAge()}"></c:out></div></div>
			<div class="row m-4"><div class="col-sm-4">Equipe</div><div class="col-sm-4 btn btn-outline-success disabled" ><c:out value="${profil.getEquipe()}"></c:out></div></div>
			<div class="row m-4"><div class="col-sm-4">Confirmer</div><div class="col-sm-4 btn btn-outline-success disabled"><c:out value="${profil.isConfirmer()}"></c:out></div></div>
			<div class="row m-4"><div class="col-sm-4">Date d'entre</div><div class="col-sm-4 btn btn-outline-success disabled"><c:out value="${profil.getDate()}"></c:out></div></div></div>


		</div>
		
		
		</div>
   </div>


<div class="row">
	<div class="col-sm-2 bg-success">
		
		<form class="form-inline border-bottom border-dange" action="AdherentDash" method="get">
			<input type="hidden" name="btn" value="evenements">
			<button disabled class="btn btn-outline-light btn-lg btn-block mb-4 mt-4 ml-2 mr-2" type="submit"><i class="fas fa-users"></i> Evenement</button>		
		</form>
		
	</div>
	<div class="col-sm-10" >
		<br>
		
		<br>
		
		
		<div class="col-sm-8 bg-white ml-4">
			<div class="row m-4"><h5>Evenements</h5></div>
			<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col"></th>
      <th scope="col">Date</th>
      <th scope="col">Debut</th>
      <th scope="col">Fin</th>
      <th scope="col">Equipe</th>
      <th scope="col"></th>
     
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${evenements }" var="evenement">
    <tr><form action="GerantDash3" method="post" class="form-inline col-sm-3">
      <th scope="row"><i class="fas fa-calendar-alt fa-2x"></i></th>
      <td><input readonly size="10" name="date" style="border-radius: 10px;border:none;height: 38px" value="${evenement.getDate() }">
      		
      </td>
      <td><input readonly size="10" name="debut" style="border-radius: 10px;border:none;height: 38px" value="${evenement.getDebut() }">
      		
      </td>
      <td><input readonly size="10" name="fin" style="border-radius: 10px;border:none;height: 38px" value="${evenement.getFin() }">
      		
      </td>
      <td><input readonly size="10" name="equipe" style="border-radius: 10px;border:none;height: 38px" value="${evenement.getEquipe() }">
      		
      </td>
      <td class="row mr-5" style="justify-content: center;">
      <input type="hidden" name="btn" value="delEv"><button  class="btn btn-outline-danger  my-sm-0" type="submit"><i class="fas fa-trash"></i></button></form>
    </tr>
    </c:forEach>
  </tbody>
</table>

		</div>
		
		
		
   </div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" integrity="sha512-RXf+QSDCUQs5uwRKaDoXt55jygZZm2V++WUZduaU/Ui/9EGp3f/2KZVahFZBKGH0s774sd3HmrhUy+SgOFQLVQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script src="assets/js/script.js"></script>	
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>