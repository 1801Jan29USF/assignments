function login() {
    let url = './login';
    let credentials = {}
    credentials.username = document.getElementById("username").value;
    credentials.password = document.getElementById("password").value;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4) {
            if (xhttp.status === 200) { 
                console.log('logged in')
                // window.location = 'http://localhost:8080/employee-reimbursement-system/statc/index.html';
                window.location = 'http://localhost:8080/employee-reimbursement-system/home';
            } else {
                alert('invalid creds');
            }
        } else {
            // response not yet ready
        }
    }
    xhttp.open('POST', url);
    xhttp.send(JSON.stringify(credentials));
}