/**
 * Created by Elvira on 13.11.2016.
 */
var request;
function postComment() {
    var comment = document.commentform.comment.value;
    var email = document.commentform.email.value;
    var product = document.commentform.product.value;
    var url = "comment.jsp?comment=" + comment + "&email=" + email + "&product=" + product;
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try {
        request.onreadystatechange = function () {
            if (request.readyState == 4) {
                var val = request.responseText;
                document.getElementById('mylocation').innerHTML = val;
            }
        }
        request.open("GET", url, true);
        request.send();
    } catch (e) {
        alert("Unable to connect to server");
    }
}
