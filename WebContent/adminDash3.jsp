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
		<h3>Evenements</h3>
		<br>
		<div class="row">
			<div class="col-sm-8" style="justify-items: start;">
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal"><i class="fas fa-calendar-plus"></i>  Ajouter Evenement</button>
			</div>
			<div class="col-sm-4" style="justify-items: end;">
				<form class="form-inline" action="GerantDash3" method="post">
				<div class="row">
					<div class="col"><input type="hidden" name="btn" value="seaEv"></div>
				    <div class="col"><input class="form-control mr-sm-2" type="date" aria-label="Search" value="none" name="searched"></div>
				    <div class="col"><button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button></div>
				 </div>
				</form>
			</div>
		</div>
		<br><br>
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
<div class="card-footer text-muted text-center">
    @2021 MyClub 
  </div>

<!-- Modal1 -->
<div class="modal fade" style="background: url('img/b.jpg');" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ajouter un Evenement</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="GerantDash3" method="post" >
      <div class="modal-body">
        
			<input type="hidden" name="btn" value="addEv">
			<input  type="date" name="date" required class="form-control mr-3" placeholder="00/00/0000"><br><br>
			<select class="custom-select" name="debut">
			  <option value="none" selected>Debut</option>
			  <option value="10:00">10:00</option>
			  <option value="12:00">12:00</option>
			  <option value="14:00">14:00</option>
			  <option value="16:00">16:00</option>
			</select><br><br>
			<select class="custom-select" name="fin">
			  <option value="none" selected>Fin</option>
			  <option value="12:00">12:00</option>
			  <option value="14:00">14:00</option>
			  <option value="16:00">16:00</option>
			  <option value="18:00">18:00</option>
			</select>
			<br><br>
			<select class="custom-select" name="equipe">
			  <option value="none" selected>Equipe</option>
			  <c:forEach items="${equipes }" var="equipe">
			  	<option value="${equipe.getNom() }">${equipe.getNom() }</option>
			  </c:forEach>
			</select><br><br>
			<br>
			
			
			
		
      </div>
      <div class="modal-footer">
      <button type="submit" class="btn btn-success">Ajouter</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        
      </div>
      </form>
    </div>
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