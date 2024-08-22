<%--
  Created by IntelliJ IDEA.
  User: fatma
  Date: 8/21/2024
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" import="java.util.*, tp_programmationweb.appweb_fermebio.modele.Client" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruits et Légumes BioBio</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('../img/farm-background2.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #2d3436;
        }

        .container {
            margin-top: 50px;
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-title {
            color: #27ae60;
        }

        .btn-primary {
            background-color: #27ae60;
            border: none;
        }

        .btn-primary:hover {
            background-color: #2ecc71;
        }

        .btn-success {
            background-color: #4CAF50;
            border: none;
        }

        .btn-success:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<c:set var="client" value="${sessionScope.client}"/>
<div>
    Bienvenue, ${client.nom}!
</div>
<div class="container text-center">
    <h1>Fruits et Légumes BioBio</h1>
    <div class="row">

        <c:set var="listProduits" value="${sessionScope.produit}"/>

        <c:forEach var="produit" items="${shoppingcart}">
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="../img/${produit.nom}.jpg" class="card-img-top" alt="Pomme">
                    <div class="card-body">
                        <h5 class="card-title">${produit.nom}</h5>
                        <p class="card-text">${produit.descriptionTraductionFr}</p>
                        <div class="form-group">
                            <label for="quantity">Quantité:</label>
                            <input type="number" id="quantity" name="quantity" class="form-control text-center"
                                   value="1" min="0" max=${produit.quantiteDisponible}>
                        </div>
                        <button type="button" class="btn btn-primary btn-block" onclick="ajouterAuPanier('Pomme')">
                            Ajouter au Panier
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>

        <!-- Ajoutez ici d'autres produits avec la même structure -->
    </div>
    <a href="../jsp/panier.jsp" class="btn btn-success mt-4">Voir le Panier</a>
</div>
<script>
    function ajouterAuPanier(item) {
        alert(item + " a été ajouté au panier!");
    }
</script>
</body>
</html>

