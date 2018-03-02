function register() {
    let url = './register';
    let credentials = {};
    credentials.username = document.getElementById("username").value;
    credentials.password0 = document.getElementById("password0").value;
    credentials.password1 = document.getElementById("password1").value;
    credentials.email = document.getElementById("email").value;
    credentials.firstName = document.getElementById("first-name").value;
    credentials.lastName = document.getElementById("lsat-name").value;
}