document.getElementById("text-form").addEventListener("submit", async function(event) {
    event.preventDefault();
    
    const text = document.getElementById("text-input").value;
    const resultsDiv = document.getElementById("results");
    const aiResult = document.getElementById("ai-result");
    const websiteResult = document.getElementById("website-result");
    
    // Make the results hidden initially
    resultsDiv.classList.add("hidden");
    
    try {
        // Call the backend API
        const response = await fetch("http://127.0.0.1:8090/api/analyze", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(text)
        });
        
        const data = await response.text();
        
        // Parse the response and update the UI
        const [aiGeneratedText, websiteText] = data.split(", Website: ");
        aiResult.textContent = aiGeneratedText;
        websiteResult.textContent = "Website: " + websiteText;
        
        // Show the results
        resultsDiv.classList.remove("hidden");
    } catch (error) {
        console.error("Error:", error);
        aiResult.textContent = "Error analyzing the text.";
        resultsDiv.classList.remove("hidden");
    }
});
