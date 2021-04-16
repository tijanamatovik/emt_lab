import axios from "../custom-axios/axios";
const bookService={

    fetchBooks:()=>{
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, category, author, availablecopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "author": author,
            "availablecopies":availablecopies
        });
    },
    editBook: (id,name, category, author, availablecopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "author": author,
            "availablecopies":availablecopies
        });
    },
    getBook: (id) => {
        return axios.get(`books/${id}`)
    },
    fetchAuthors: () => {
    return axios.get("/authors")
    },
    fetchCategories: () => {
        return axios.get("/books/categories")
    },
    markBookAsTaken: (id) => {
      return axios.post(`books/available-copies/${id}`)
    }
}
export default bookService;