/**
$( document ).ready(function() {
    var theTemplateScript = $("#address-template").html();

    // Compile the template
    var theTemplate = Handlebars.compile(theTemplateScript);

    // Define our data object
    var context={
        "city": "London",
        "street": "Baker Street",
        "number": "221B"
    };

    // Pass our data to the template
    var theCompiledHtml = theTemplate(context);

    // Add the compiled html to the page
    $('.content-placeholder').html(theCompiledHtml);
});
*/

$( document ).ready(function(){
    // Grab the template script
    var theTemplateScript = $("#address-template").html();

    // Compile the template
    var theTemplate = Handlebars.compile(theTemplateScript);

    // Define our data object
    var context={
        "description": {
            "escaped": "Using {{}} brackets will result in escaped HTML:",
            "unescaped": "Using {{{}}} will leave the context as it is:"
        },
        "example": "<button> Hello </button>"
    };

    // Pass our data to the template
    var theCompiledHtml = theTemplate(context);

    // Add the compiled html to the page
    $('.content-placeholder').html(theCompiledHtml);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var theTemplateScript = $("#example-template").html();

    // Compile the template
    var theTemplate = Handlebars.compile(theTemplateScript);

    // This is the default context, which is passed to the template
    var context = {
        people: [
            { firstName: 'Homer', lastName: 'Simpson' },
            { firstName: 'Peter', lastName: 'Griffin' },
            { firstName: 'Eric', lastName: 'Cartman' },
            { firstName: 'Kenny', lastName: 'McCormick' },
            { firstName: 'Bart', lastName: 'Simpson' }
        ]
    };

    // Pass our data to the template
    var theCompiledHtml = theTemplate(context);

    // Add the compiled html to the page
    $(document.body).append(theCompiledHtml);
});