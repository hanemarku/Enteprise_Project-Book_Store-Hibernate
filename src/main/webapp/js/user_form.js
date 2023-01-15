
        $(function() {
                $("#message").hide();
                $("#message1").hide();
                $("#message6").hide();
                $("#message3").hide();


                // $("#message9").hide();

                var message_fullname = false;
                var message_fjalekalim = false;
                var message_konf_fjalekalim = false;
                var message_email = false;


                $("#confirm_pass").keyup(function(){
                        checkPassword();
                });

                $("#password").keyup(function(){
                        checkPasswordValidation();
                });

                $("#fullname").keyup(function(){
                        checkfullname();
                });

                $("#email").keyup(function(){
                        checkEmailValidation();
                });



                function checkPasswordValidation() {
                        var upperCaseLetters = /[A-Z]/g;
                        var lowerCaseLetters = /[a-z]/g;
                        var numbers = /[0-9]/g;
                        var specialCharacter = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
                        var pass = $("#password").val().trim();
                        if(pass === ''){
                                $("#message1").html("Password is required!").css('color', '#890F0D');
                                $("#message1").show();
                                $("#password").css("border-bottom","2px solid #F90A0A");
                                message_fjalekalim = true;
                        }else
                        if(!pass.match(lowerCaseLetters) || !pass.match(upperCaseLetters) || !pass.match(numbers)
                            || !pass.match(specialCharacter) || pass.length < 8){
                                $("#message1").html(" A password should have at least one uppercase letter, one lowercase letter, a number and a special character").css('color', '#890F0D');
                                $("#message1").show();
                                $("#password").css("border-bottom","2px solid #F90A0A");
                                message_fjalekalim = true;
                        }else{
                                $("#message1").hide();
                                $("#password").css("border-bottom","2px solid #34F458");
                        }
                }


                function checkPassword() {
                        if ($("#password").val().trim() == $("#confirm_pass").val().trim()){
                                $("#message").html("Passwords match !").css('color', '#5dd05d');
                                $("#message").show();
                                $("#confirm_pass").css("border-bottom","2px solid #34F458");
                        } else {
                                $("#message").html("Be carefull! Password do not match").css('color', '#890F0D');
                                $("#message").show();
                                $("#confirm_pass").css("border-bottom","2px solid #F90A0A");
                                message_konf_fjalekalim = true;
                        }
                }
                function checkfullname() {
                        var fullname = $("#fullname").val().trim();
                        if(fullname.length < 2) {
                                $("#message6").html("Full Name can not be less than 2 characters !").css('color', '#890F0D');
                                $("#message6").show();
                                $("#fullname").css("border-bottom","2px solid #F90A0A");
                                message_fullname = true;
                        }else{
                                $("#message6").hide();
                                $("#fullname").css("border-bottom","2px solid #34F458");
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




                $("#form").submit(function() {
                        message_konf_fjalekalim = false;
                        message_fjalekalim = false;
                        message_fullname = false;
                        message_email = false;

                        checkPassword();
                        checkPasswordValidation();
                        checkfullname();
                        checkEmailValidation();


                        if ( message_konf_fjalekalim === false && message_fjalekalim === false && message_fullname === false && message_email == false ) {
                                return true;
                        } else {
                                Swal.fire('Please fill all fields with valid values!');
                                return false;
                        }
                        });
                });







