<%--
  Created by IntelliJ IDEA.
  User: fatma
  Date: 8/21/2024
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Votre Panier - Fruits et Légumes BioBio</title>
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
        .table th, .table td {
            vertical-align: middle;
        }
        .btn-danger {
            background-color: #e74c3c;
            border: none;
        }
        .btn-danger:hover {
            background-color: #c0392b;
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
<body><c:set var="client" value= "${sessionScope.client}"  />
<div>
    Bienvenue, ${client.nom}!
</div>
<div class="container">
    <h1 class="text-center">Votre Panier</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Produit</th>
            <th>Quantité</th>
            <th>Prix Unitaire</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Pomme</td>
            <td>2</td>
            <td>1.00€</td>
            <td>2.00€</td>
            <td>
                <button class="btn btn-danger" onclick="retirerDuPanier('Pomme')">Retirer</button>
            </td>
        </tr>
        <!-- Ajoutez d'autres articles ici -->
        </tbody>
    </table>
    <div class="text-right">
        <h3>Total: 2.00€</h3>
        <a href="../confirmation.html" class="btn btn-success btn-block">Passer à la caisse</a>
    </div>
</div>
<script>
    function retirerDuPanier(item) {
        alert(item + " a été retiré du panier!");
    }
</script>
</body>

</html>
