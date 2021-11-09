
	<%@page import="Web.CreditModel"%>
<%
		CreditModel model =(CreditModel) request.getAttribute("creditModel") ; 

// faire un cast 

	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Crédit Bancaire </title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
	<p> </p>
	<div class="container"> 
	  <div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading"> Simulation du credit 
			</div>
			<div class="panel-body" >
			  <form action="calculMensualite.do" method="post">
			  	 <div  class="form-group">
			  	    <label class="control-label">Montant : </label>
			  	     <input type="text" class="form-control" name="montant" value="<%=model.getMontant()%>"/>
			  	     
			  	 </div>
			  	 
			  	  <div  class="form-group">
			  	    <label class="control-label">Taux : </label>
			  	     <input type="text" class="form-control" name="montant" value="<%=model.getTaux()%>"/>
			  	     
			  	 </div>
			  	 
			  	  <div  class="form-group">
			  	    <label class="control-label">Duree : </label>
			  	     <input type="text" class="form-control" name="montant" value="<%=model.getDuree()%>"/>
			  	     
			  	 </div>
			  	 
			  	 <button class="btn btn-danger" type="SUBMIT">Calculer</button>
			  	 
			  	 <div> 
			  	 
		 	<label>  Mensualité:</label>
		 	
		 	<label> <%= model.getMensualite()  %>  </label> 
				</div>
		
			  </form>
			
			</div>
		
		</div>
	</div>
</div>
</body>
</html> 