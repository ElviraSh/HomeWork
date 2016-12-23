$(document).ready(function(e) {
    $("#btn_check").click(function (e){
        resetErrors();
        result = true;
        if (!checkName()){
            result = false;
        }
        if (!checkEmail()){
            result = false;
        }
        if (!checkPassword()){
            result = false;
        }



        if (result){
            e.submit();
        }
        else{
            e.preventDefault();
        }
    });
    checkName = function(){
        if( $("#name").val().length > 0){
            return true;
        } else {

            addError($("#fname"), "Invalid:");
            return false;
        }
    };
    checkEmail = function() {
        var reg = new RegExp("^(?:[a-zA-Z0-9\\._])+@(?:[a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]+$", "i");
        if (reg.test($("#email").val()) && $("#email").val().length > 0){
            return true;
        }
        else{
            addError($("#femail"), "Invalid:");
            return false;
        }
    };
    checkPassword = function(){
        if (($("#password1").val() === $("#password2").val()) && ($("#password1").val().length > 3)){
            return true;
        }
        else{
            addError($("#fpassword"), "Invalid (length < 4 or passwords don't some):");
            return false;
        }
    };


    addError = function(e, text){
        $("<span></span>").addClass("error").text(text).css("display", "inline").css("color", "red").prependTo(e);
        e.find("input").css("border-color", "red");
    };
    resetErrors = function(){
        $(".error").remove();
        $(".field").css("border-color", "");
    };
});