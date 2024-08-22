<%--
  Created by IntelliJ IDEA.
  User: fatma
  Date: 8/19/2024
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" import="java.util.*, tp_programmationweb.appweb_fermebio.modele.Client" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruits et Légumes Bio</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f9f9f9;
        }
        .navbar-brand {
            font-weight: bold;
        }
        .banner {
            background-image: url('${pageContext.request.contextPath}/img/farm-background2.jpg');
            background-size: cover;
            background-position: center;
            color: white;
            text-align: center;
            padding: 100px 0;
        }
        .banner h1 {
            font-size: 3em;
            margin-bottom: 20px;
        }
        .banner p {
            font-size: 1.5em;
        }
    </style>
</head>
<body>
<c:set var="client" value= "${sessionScope.client}"  />
<div>
     Bienvenue, ${client.nom}!
</div>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">Fruits & Légumes Bio</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/AffichagePrdServlet">Nos Produits</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/confirmation.html">Contactez-nous</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Banner -->
<div class="banner">
    <h1>Bienvenue chez Fruits & Légumes Bio</h1>
    <p>Des produits frais et biologiques directement de la ferme à votre table</p>
</div>

<!-- Main content -->
<div class="container mt-5">
    <div class="row">
        <div class="col-md-4">
            <h2>Produits de qualité</h2>
            <p>Nous vous offrons une large sélection de fruits et légumes bio, cultivés avec soin et respect de l'environnement.</p>
        </div>
        <div class="col-md-4">
            <h2>Nos engagements</h2>
            <p>Notre mission est de vous fournir des produits sains, savoureux et certifiés biologiques.</p>
        </div>
        <div class="col-md-4">
            <h2>Contactez-nous</h2>
            <p>Pour toute question ou commande, n'hésitez pas à nous contacter. Nous sommes là pour vous servir.</p>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-light text-center p-3 mt-5">
    <p>&copy; 2024 Fruits & Légumes Bio. Tous droits réservés.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
