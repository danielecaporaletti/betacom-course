<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registrazione</title>
</head>
<body>
  <h1>Registrazione</h1>
  <form action="RegistrazioneServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br><br>
    <label for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome" required><br><br>
    <input type="submit" value="Registrati">
  </form>
</body>
</html>