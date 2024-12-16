
document.addEventListener("DOMContentLoaded", () => {
  const inputForm = document.getElementById("inputForm");
  const inputType = document.getElementById("inputType");
  const fileInputDiv = document.getElementById("fileInputDiv");
  const inputFileName = document.getElementById("inputFileName");
  const otherInputs = document.getElementById("otherInputs");
  const numberOfMatrices = document.getElementById("numberOfMatrices");
  const dimensions = document.getElementById("dimensions");
  const delimiter = document.getElementById("delimiter");
  const multiply = document.getElementById("multiply");
  const outputMessage = document.getElementById("outputMessage");

  // Toggle form fields based on input type
  inputType.addEventListener("change", () => {
    if (inputType.value === "1") {
      inputFileName.required = true;
      fileInputDiv.style.display = "block";
      otherInputs.style.display = "none";
      numberOfMatrices.required = false;
      dimensions.required = false;
      delimiter.required = false;
      multiply.required = false;
    } else {
      inputFileName.required = false;
      fileInputDiv.style.display = "none";
      otherInputs.style.display = "block";
      numberOfMatrices.required = true;
      dimensions.required = true;
      delimiter.required = true;
      multiply.required = true;
    }
  });

  // Form submission handler
  inputForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    let valid = true;

    // Validate input type
    if (!inputType.value) {
      valid = false;
      alert("Please select an input type.");
    }

    if (inputType.value === "1") {
      if (!inputFileName.value.endsWith(".txt")) {
        valid = false;
        alert("File name must end with .txt.");
      }
    } else {
      if (!numberOfMatrices.value || parseInt(numberOfMatrices.value) < 1) {
        valid = false;
        alert("Enter a valid number of matrices.");
      }

      if (!dimensions.value.match(/^(\d+)x\1$/)) {
        valid = false;
        alert("Enter valid dimensions in NxN format.");
      }

      if (!delimiter.value || delimiter.value.length !== 1 || /[a-zA-Z0-9]/.test(delimiter.value)) {
        valid = false;
        alert("Delimiter must be a single non-alphanumeric character.");
      }
    }

    if (valid) {
      try {

		
        // Build the Protobuf message
        const payload = 
          "inputType:"+parseInt(inputType.value)+
          "inputFileName:" + inputFileName.value || "" +
          "numberOfMatrices:"+ parseInt(numberOfMatrices.value) || 0+
          "dimensions:"+ dimensions.value || ""+
          "delimiter:"+ delimiter.value || ";"+
          "multiply:"+ parseInt(multiply.value) || 0
        ;
		const response = await fetch("http://localhost:50051/userinput.UserInputService/CreateUserInput", {
		  method: "POST",
		  headers: {
		    "Content-Type": "application/grpc-web+proto",
		  },
		  body: payload, // Serialized protobuf payload
		});

		console.log("response",response)

      
        outputMessage.innerText = "Form submitted and Protobuf message encoded successfully!";
      } catch (err) {
        console.error("Protobuf Error:", err);
        outputMessage.innerText = "An error occurred while processing the form.";
      }
    }
  });
});