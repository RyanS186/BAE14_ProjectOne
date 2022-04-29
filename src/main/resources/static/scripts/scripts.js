'use strict'

const address = "http://localhost:8080/records"

// Divs
const results_div = document.querySelector("#results-div");

// GET request
const getAll = () => {
    axios.get(`${address}/getAll`)
        .then((response) => {
            results_div.innerHTML = "";
            const results = response.data;

            for (let result of results) {
                printResult(result);
            }
        }).catch((err) => console.error(err))
}

// POST request
const openAdd = () => {
    // Get the modal and opens it
    const createModal = document.getElementById("create-modal");
    createModal.style.display = "block";

    // Gets the <span> that closes this modal
    const span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span>, close the modal
    span.onclick = function() {
        createModal.style.display = "none";
      }

    // When the user clicks outside of the modal, close the modal
    window.onclick = function(event) {
    if (event.target == createModal) {
        createModal.style.display = "none";
    }
    } 

    document.querySelector("#create-form").addEventListener('submit', (e) => {
        e.preventDefault(); // stops the form submitting in the default way
    
        const form = e.target;
    
        const data = {
            albumName: form.album.value,
            artistName: form.artist.value,
            genre: form.genre.value,
            releaseYear: form.year.value
        }
    
        console.log("DATA: ", data);
    
        axios.post(`${address}/create`, data)
        .then((res) => {
            console.log(res);
            getAll();
    
            form.reset(); //resets form
            form.name.focus(); // selects the name input
        }).catch(err => console.log(err));
    });
}

// PUT request
const openEdit = (id) => {
    // Gets the modal and opens it
    const editModal = document.getElementById("edit-modal");
    editModal.style.display = "block";

    axios.get(`${address}/getById/${id}`)
        .then((res) => {
            const entry = res.data;
            // Populates the edit form with current values
            const edit_form = document.forms["edit-form"];
            edit_form.album.value = entry.albumName;
            edit_form.artist.value = entry.artistName;
            edit_form.genre.value = entry.genre;
            edit_form.year.value = entry.releaseYear;

            // Gets the <span> that closes this modal
            const span = document.getElementsByClassName("close")[1];

            // When the user clicks on <span>, close the modal
            span.onclick = function() {
                editModal.style.display = "none";
            }

            // When the user clicks outside of the modal, close the modal
            window.onclick = function(event) {
                if (event.target == editModal) {
                  editModal.style.display = "none";
                }
            } 

            document.querySelector("#edit-form").addEventListener('submit', (e) => {
                e.preventDefault(); // stops the form submitting in the default way
                
                // Takes new values from the form
                const form = e.target;
                const data = {
                    albumName: form.album.value,
                    artistName: form.artist.value,
                    genre: form.genre.value,
                    releaseYear: form.year.value
                }

                console.log("DATA: ", data);
                
                // PUT request
                axios.put(`${address}/update/${id}`, data)
                    .then((res) => {
                        console.log(res);
                        getAll();
                        editModal.style.display = "none";
                    }).catch((err) => console.error(err))

            /* To resolve BAE1-54, I've added the EventListener option 'once'. 
            This prevents the previous EventListeners from remaining active. */
        },{once: true}).catch((err) => console.error(err))

})
}

// DELETE request
const deleteRecord = (id) => {
    axios.delete(`${address}/delete/${id}`)
        .then(res => {
            console.log(res);
            getAll();
        }).catch(err => console.log(err));
}

// Method to construct objects on the webpage to display objects from the API
const printResult = (result) => {

    const linebreak = document.createElement("br");

    const column_div = document.createElement("div");
    column_div.setAttribute("class", "column");
    
    const card_div = document.createElement("div");
    card_div.setAttribute("class", "card");

    const album_img = document.createElement("img");
    album_img.setAttribute("class", "artwork");
    // album_img.setAttribute("src", `${result.albumArtwork}`)

    const album_name = document.createElement("div");
    album_name.setAttribute("class", "album-info");
    album_name.textContent = `${result.albumName}`;

    const artist_name = document.createElement("div");
    artist_name.setAttribute("class", "album-info");
    artist_name.textContent = `${result.artistName}`;

    const release_year = document.createElement("div");
    release_year.setAttribute("class", "album-info");
    release_year.textContent = `${result.releaseYear}`;

    const spotify = document.createElement("button");
    spotify.type = "button";
    spotify.setAttribute("class", "spotify-btn");
    // spotify.setAttribute("href", `${result.spotifyLink}`)

    const spotify_img = document.createElement("img");
    spotify_img.setAttribute("style", "width:125px");
    spotify_img.setAttribute("src", "../images/spotify/Spotify_Logo_RGB_Black.png")

    const edit = document.createElement("button");
    edit.type = "button";
    edit.textContent = "Edit"
    edit.id = `${result.id}`;
    edit.setAttribute("class", "edit-btn");
    edit.setAttribute("onClick", "openEdit(this.id)");

    const remove = document.createElement("button");
    remove.type = "button";
    remove.textContent = "Remove";
    remove.id = `${result.id}`;
    remove.setAttribute("class", "remove-btn");
    remove.setAttribute("onClick", "deleteRecord(this.id)");

    spotify.appendChild(spotify_img);

    card_div.appendChild(album_img);
    card_div.appendChild(album_name);
    card_div.appendChild(linebreak);
    card_div.appendChild(artist_name);
    card_div.appendChild(linebreak);
    card_div.appendChild(release_year);
    card_div.appendChild(linebreak);
    card_div.appendChild(spotify);
    card_div.appendChild(linebreak);
    card_div.appendChild(edit);
    card_div.appendChild(remove);

    column_div.appendChild(card_div);
    results_div.appendChild(column_div);
}