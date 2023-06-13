$(document).ready(DisplayRegisterStudents)

function DisplayShowAll() {

    document.getElementById("allStudents").hidden = false;
    document.getElementById("registerStudent").hidden = true;
    document.getElementById("updateStudent").hidden = true;
    document.getElementById("getStudent").hidden = true;
    document.getElementById("deleteStudent").hidden = true;

}

function DisplayRegisterStudents() {


    document.getElementById("allStudents").hidden = true;
    document.getElementById("registerStudent").hidden = false;
    document.getElementById("updateStudent").hidden = true;
    document.getElementById("getStudent").hidden = true;
    document.getElementById("deleteStudent").hidden = true;


}

function DisplayUpdateStudent() {

    document.getElementById("allStudents").hidden = true;
    document.getElementById("updateForm").hidden = true;
    document.getElementById("registerStudent").hidden = true;
    document.getElementById("updateStudent").hidden = false;
    document.getElementById("getStudent").hidden = true;
    document.getElementById("deleteStudent").hidden = true;
    $('form#updateForm').hide();

}

function DisplayGetStudent() {

    document.getElementById("allStudents").hidden = true;
    document.getElementById("registerStudent").hidden = true;
    document.getElementById("updateStudent").hidden = true;
    document.getElementById("getStudent").hidden = false;
    document.getElementById("deleteStudent").hidden = true;

}

function DisplayDeleteStudent() {

    document.getElementById("allStudents").hidden = true;
    document.getElementById("registerStudent").hidden = true;
    document.getElementById("updateStudent").hidden = true;
    document.getElementById("getStudent").hidden = true;
    document.getElementById("deleteStudent").hidden = false;

}

function Hide() {

    document.getElementById("allStudents").hidden = true;
    document.getElementById("registerStudent").hidden = true;
    document.getElementById("updateStudent").hidden = true;
    document.getElementById("getStudent").hidden = true;
    document.getElementById("deleteStudent").hidden = true;
    console.log("TEST");
}



//GET ALL STUDENTS 
$(document).ready(function () {

    $("li#showAll").click(function () {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/',
            success: function (studentArray) {
                var studentsTable = $('tbody#allStudentsTable');
                // console.log(studentsTable)
                //$("div#allContacts").html(result);
                //alert("result:" + studentArray);

                //display the section
                DisplayShowAll();

                $('tbody#allStudentsTable').children('.stud').remove();
                $.each(studentArray, function (index, student) {


                    var studentInfo = '<tr class="stud">';
                    studentInfo += '<th scope = "row">' + student.id + '</th>';
                    studentInfo += '<td>' + student.name + '</td>';
                    studentInfo += '<td>' + student.age + '</td>';
                    studentInfo += '<td>' + student.mobile + '</td>';
                    studentInfo += '<td>' + student.address + '</td>';
                    studentInfo += '</tr>';

                    studentsTable.append(studentInfo);
                })
            },
            error: function (xhr) {
                //display the section
                DisplayShowAll();

                if (xhr.status == 404) {
                    alert("User not found");
                }
                if (xhr.status == 400) {
                    alert("Invalid Data Entered");
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }
            }
        })
    });

})

//GET SPECIFIC STUDENT
$(document).ready(function () {

    $("button#getOneStudent").click(function () {

        if ($('input#sIDSearch').val() == "") {
            alert("ID field cannot be empty");
            return;
        }
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/' + $('input#sIDSearch').val(),
            success: function (studentArray) {

                if (studentArray.length == 0) {
                    alert("ID must be entered");
                    return;
                }
                var studentsTable = $('tbody#singleStudentsTable');

                console.log(studentArray);
                //display the section
                DisplayGetStudent();

                $('tbody#singleStudentsTable').children('.stud').remove();
                // $.each(studentArray, function(index, student) {


                var studentInfo = '<tr class="stud">';
                studentInfo += '<th scope = "row">' + studentArray.id + '</th>';
                studentInfo += '<td>' + studentArray.name + '</td>';
                studentInfo += '<td>' + studentArray.age + '</td>';
                studentInfo += '<td>' + studentArray.mobile + '</td>';
                studentInfo += '<td>' + studentArray.address + '</td>';
                studentInfo += '</tr>';

                studentsTable.append(studentInfo);
                // })
            },
            error: function (xhr) {
                $('tbody#singleStudentsTable').children('.stud').remove();

                if (xhr.status == 404) {
                    alert("User not found");
                }
                if (xhr.status == 400) {
                    alert("Invalid Data Entered");
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }
            }
        })
    });

})

//Delete SPECIFIC STUDENT
$(document).ready(function () {

    $("button#delButton").click(function () {
        if ($('input#delID').val() == "") {
            alert("ID field cannot be empty");
            return;
        }
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:9999/students/' + $('input#delID').val(),
            success: function (studentArray) {
                console.log(studentArray)
                alert("Student Deleted")



            },
            error: function (xhr) {
                // var err = JSON.parse(xhr.responseText); 
                // console.log(xhr);
                // console.log(err);

                if (xhr.status == 400) {
                    alert("Invalid Data Entered");
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }
                if (xhr.status == 404) {
                    alert("User not found");
                }


            }
        })
    });

})

//Register STUDENT 
$(document).ready(function () {

    $("button#registerButton").click(function () {
        $.ajax({
            type: 'POST',
            data: JSON.stringify({ 'name': $('input#regName').val(), 'age': $('input#regAge').val(), 'mobile': $('input#regMobile').val(), 'address': $('input#regAddress').val() }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: 'http://localhost:9999/students',
            success: function (studentArray) {
                alert("Your details have been saved. Your Student ID is: " + studentArray.id);




            },
            error: function (xhr) {
                var err = JSON.parse(xhr.responseText);
                console.log(xhr);
                console.log(err);

                if (xhr.status == 400) {
                    alert(err.message + ": " + err.details);
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }


            }
        })
    });

})
// Update search button
$(document).ready(function () {
    $("button#updateSearch").click(function () {
        if ($('input#updateID').val() == "") {
            alert("ID field cannot be empty");
            return;
        }
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/' + $('input#updateID').val(),
            success: function (studentArray) {
                // console.log(studentArray)
                // alert($('input#updateID').val());
                $('form#updateForm').show();

                $('input#updateName').val(studentArray.name);
                $('input#updateMobile').val(studentArray.mobile);
                $('input#updateAddress').val(studentArray.address);
                // console.log(studentArray.address)
                $('label#storeID').html(studentArray.id);
                $('label#storeAge').html(studentArray.age);



            },
            error: function (xhr) {
                // var err = JSON.parse(xhr.responseText); 
                // console.log(xhr);
                // console.log(err);

                if (xhr.status == 400) {
                    alert("Invalid Data Entered");
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }
                if (xhr.status == 404) {
                    alert("User not found");
                }


            }
        })
    });

})


// Update details button
$(document).ready(function () {

    $("button#updateStudentDetails").click(function () {

        $.ajax({
            type: 'PUT',
            data: JSON.stringify({ 'id': $('label#storeID').html(), 'name': $('input#updateName').val(), 'age': $('label#storeAge').html(), 'mobile': $('input#updateMobile').val(), 'address': $('input#updateAddress').val() }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: 'http://localhost:9999/students',
            success: function (studentArray) {

                
                alert("Update Successful");




            },
            error: function (xhr) {
                // var err = JSON.parse(xhr.responseText); 
                // console.log(xhr);
                // console.log(err);

                if (xhr.status == 400) {
                    alert("Invalid Data Entered");
                }
                if (xhr.status == 500) {
                    alert("Internal Server Error");
                }


            }
        })
    });

})
