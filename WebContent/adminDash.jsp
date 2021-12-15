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
		<form class="form-inline border-bottom border-dange" action="GerantDash" method="Post">
			<input type="hidden" name="btn" value="Equipes">
			<button class="btn btn-outline-light btn-lg btn-block mb-4 mt-5 ml-2 mr-2" type="submit"><i class="fas fa-tshirt"></i> Equipes</button>		
		</form>
		<form class="form-inline border-bottom border-dange" action="GerantDash" method="post">
			<input type="hidden" name="btn" value="membres">
			<button class="btn btn-outline-light btn-lg btn-block mb-4 mt-4 ml-2 mr-2" type="submit"><i class="fas fa-users"></i> Membres</button>		
		</form>
		<form class="form-inline border-bottom border-dange" action="GerantDash" method="post">
			<input type="hidden" name="btn" value="evenements">
			<button class="btn btn-outline-light btn-lg btn-block mb-4 mt-4 ml-2 mr-2" type="submit"><i class="fas fa-calendar-alt"></i> Evenements</button>		
		</form>
	</div>
	<div class="col-sm-10" >
		<br>
		<h3>Equipes</h3>
		<br>
		<div class="row">
			<div class="col-sm-8" style="justify-items: start;">
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal"><i class="fas fa-tshirt"></i><i class="fas fa-plus"></i>  Creer une equipe</button>
			</div>
			<div class="col-sm-4" style="justify-items: end;">
				<form class="form-inline" action="GerantDash" method="post">
					<input type="hidden" name="btn" value="seaEq">
				    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
				    <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
				</form>
			</div>
		</div>
		<br><br>
		<div class="card-columns">
		<c:forEach items="${equipes}" var="equipe">
		  <div class="card border-danger " style="padding: 8px;">
		    <div class="row border-bottom border-danger card-header" style="padding: 10px;"><div class="col-sm-4"><i style="color: red;" class="fas fa-users fa-2x"></i></div><div class="col-sm-6 ">${equipe.getNom() }<br>  ${equipe.getSport() } | ${equipe.getGenre() }</div><div class="col-sm-2" ><form action="GerantDash" method="post" class="form-inline"><input type="hidden" name="btn" value="delEq" ><input type="hidden" value="${equipe.getNom() }" name="nomEq"><button  class="btn btn-outline-danger my-2 my-sm-0" type="submit"><i class="fas fa-trash"></i></button></form></div></div>
		    <div class="card-body">
		      <div class="row">
		      	<div class="col-sm-6 border-right border-danger">
			      	<h5>Membres</h5>
			      	<p>${equipe.getMembres() } membres</p>
		      	</div>
		      	<div class="col-sm-6">
			      	<h5>Coach</h5>
			      	<p>${equipe.getCoach() }</p>
		      	</div>
		      </div>
		      <br>
		      <div class="d-flex justify-content-center border-top border-danger" style="padding-top: 10px ">
		      	<div  class="form-inline"><button data-toggle="modal" data-target="#${equipe.getNom() }" class="btn btn-outline-success my-2 my-sm-0" type="button"><i class="fas fa-eye"></i> Voir l'equipe</button></div>
		      	<div class="modal fade bd-example-modal-sm"  id="${equipe.getNom() }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog modal-sm" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel"><i style="color: red;" class="fas fa-users fa-2x"></i> ${equipe.getNom() }</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        
							<div class="card border-success mb-3 " >
							  <div class="card-header bg-transparent border-success">Sport : ${equipe.getSport() }</div>
							  <div class="card-header bg-transparent border-success">Coach : ${equipe.getCoach() }</div>
							  <div class="card-header bg-transparent border-success">Genre : ${equipe.getGenre() }</div>
							  <div class="card-header bg-transparent border-success">Nombre de membres : ${equipe.getMembres() }</div>
							  <div class="card-header bg-transparent border-success">Tranche d'age : ${equipe.getTranche() }</div>
							  <div class="card-header bg-transparent border-success">Niveau de pratique : ${equipe.getNiveau() }</div>
							</div>
						
				      </div>
				    </div>
				  </div>
				</div>
		      	
		      </div>
		      
		    </div>
		  </div>
		  </c:forEach>
		</div>
		
	</div>
</div>





<!-- Modal1 -->
<div class="modal fade" style="background: url('img/b.jpg');" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ajouter une equipe</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="GerantDash" method="post" >
      <div class="modal-body">
        
			<input type="hidden" name="btn" value="addEq">
			<input  type="text" name="nom" required class="form-control mr-3" placeholder="Nom d'equipe"><br>
			<select style="margin-bottom: 20px" class="custom-select" name="coach">
			  <option value="none" selected>Coach</option>
			  <c:forEach items="${coachs }" var="coach">
			  	<option value="${coach.getNom() }">${coach.getNom() }</option>
			  </c:forEach>
			</select><br>
			<select  style="margin-bottom: 20px" class="custom-select" name="sport">
			    <option value="none" selected>Sport</option>
			  	<option value="FootBall">FootBall</option>
			  	<option value="Tennis">Tennis</option>
			  	<option value="HandBall">HandBall</option>
			  	<option value="Musculation">Musculation</option>
			</select><br>
			<select style="margin-bottom: 20px" class="custom-select" name="genre">
			    <option value="Mixte" selected>Genre</option>
			  	<option value="Hommes">Hommes</option>
			  	<option value="femmes">femmes</option>
			  	<option value="Mixte">Mixte</option>
			</select><br>
			<select style="margin-bottom: 20px"  class="custom-select" name="tranche">
			    <option value="Tous" selected>Age</option>
			    <option value="Enfants">Enfants</option>
			  	<option value="Jeunes">Jeunes</option>
			  	<option value="Adultes">Adultes</option>
			  	<option value="Tous">Tous</option>
			</select><br>
			<select style="margin-bottom: 20px" class="custom-select" name="niveau">
			    <option value="Tous" selected>Niveau</option>
			    <option value="Debutant">Debutant</option>
			  	<option value="Moyen">Moyen</option>
			  	<option value="Avancee">Avancee</option>
			  	<option value="Tous">Tous</option>
			</select><br>
			
			
			
		
      </div>
      <div class="modal-footer">
      <button type="submit" class="btn btn-success">Ajouter</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        
      </div>
      </form>
    </div>
  </div>
</div>

<!-- Modal2 -->


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