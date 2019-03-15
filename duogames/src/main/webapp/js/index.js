var url_string = window.location.href;
var url = new URL(url_string);
var paramValue = url.searchParams.get("error");

if (paramValue === null) {

} else {
    alert("Wrong Username or Password")
}
