const books = [
  { title: "Women", image: "images/women.jpg" },
  { title: "Men", image: "images/men.jpg" },
  { title: "Children", image: "images/children.jpg" }
];

function searchBook() {
  const query = document.getElementById("searchBox").value.toLowerCase();
  const resultDiv = document.getElementById("results");
  resultDiv.innerHTML = "";

  let found = false;
  books.forEach(book => {
    if (book.title.toLowerCase().includes(query)) {
      resultDiv.innerHTML = `
        <div class="book">
          <h3>${book.title}</h3>
          <img src="${book.image}" alt="${book.title}">
        </div>`;
      found = true;
    }
  });

  if (!found) {
    resultDiv.innerHTML = `
      <div class="book">
        <h3>Default Book</h3>
        <img src="images/default.jpg" alt="Default Book">
      </div>`;
  }
}
