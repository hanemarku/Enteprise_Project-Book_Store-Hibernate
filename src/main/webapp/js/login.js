
$(function() {
    $("#message1").hide();
    $("#message3").hide();

    var message_fjalekalim = false;
    var message_email = false;


    $("#password").keyup(function(){
        checkPasswordValidation();
    });

    $("#email").keyup(function(){
        checkEmailValidation();
    });



    function checkPasswordValidation() {
        var pass = $("#password").val().trim();
        if(pass === ''){
            $("#message1").html("Password is required!").css('color', '#890F0D');
            $("#message1").show();
            $("#password").css("border-bottom","2px solid #F90A0A");
            message_fjalekalim = true;
        }else{
            $("#message1").hide();
            $("#password").css("border-bottom","2px solid #34F458");
        }
    }




    const isValidEmail = email => {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }
    function checkEmailValidation() {
        var email = $("#email").val().trim();
        if(email === '') {
            $("#message3").html("Email is required!").css('color', '#890F0D');
            $("#message3").show();
            $("#email").css("border-bottom","2px solid #F90A0A");
            message_email = true;
        } else if (!isValidEmail(email)) {
            $("#message3").html("Your email format is not valid !").css('color', '#890F0D');
            $("#message3").show();
            $("#email").css("border-bottom","2px solid #F90A0A");
            message_email = true;
        } else{
            $("#message3").hide();
            $("#email").css("border-bottom","2px solid #34F458");
        }
    }

    $("#formLogin").submit(function() {
        message_fjalekalim = false;
        message_email = false;

        checkPasswordValidation();
        checkEmailValidation();


        if (message_fjalekalim === false && message_email === false ) {
            return true;
        } else {
            Swal.fire('Please fill all fields with valid values!');
            return false;
        }
    });
});







