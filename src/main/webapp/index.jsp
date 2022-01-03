<html>
<head>
  <meta charset="utf-8">
 </head>

<body>
<p>Welcome to Spring MVC Tutorial</p>

<a href="hello">Click here...</a>
<a href="user">Spring MVC</a>

<p style="text-align: center"><button>Parse</button>

<form method="post" action="/parseUsers">
        <label for="firstName">First Name
            <input class="input-field" type="text" id="firstName" name="firstName">
        </label>
        <label for="lastName">Last Name
            <input class="input-field" type="text" id="lastName" name="lastName">
        </label>
        <input type="submit" value="Parse">
    </form>

<form method="post" action="/parseInfo">
        <input type="submit" value="ParseInfo">
    </form>

</body>
</html>