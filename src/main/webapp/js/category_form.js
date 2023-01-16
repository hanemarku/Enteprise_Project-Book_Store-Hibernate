


$(function() {
    $("#message").hide();
    var message_name = false;

    $("#name").keyup(function(){
        checkName();
    });


    function checkName() {
        var name = $("#name").val().trim();
        if(name.length < 1) {
            $("#message").html("Name is required!").css('color', '#890F0D');
            $("#message").show();
            $("#name").css("border-bottom","2px solid #F90A0A");
            message_name = true;
        }else{
            $("#message").hide();
            $("#name").css("border-bottom","2px solid #34F458");
        }
    }

    $("#formCategory").submit(function() {
        message_name = false;
        checkName();
        if ( message_name === false  ) {
            return true;
        } else {
            Swal.fire('Name is required');
            return false;
        }
    });
});


