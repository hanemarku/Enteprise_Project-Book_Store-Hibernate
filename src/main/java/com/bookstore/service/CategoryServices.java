package com.bookstore.service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CategoryServices {
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        categoryDAO = new CategoryDAO();
    }

    public void listCategories() throws ServletException, IOException {
        listCategories(null);
    }

    public void listCategories(String message) throws ServletException, IOException {
        List<Category> categories = categoryDAO.listAll();
        request.setAttribute("listCategory", categories);
        String listPage = "category_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        if(message != null){
            request.setAttribute("message", message);

        }

        requestDispatcher.forward(request, response);

    }

    public void createCategory() throws ServletException, IOException {
        String name = request.getParameter("name");

        Category existCategory = categoryDAO.findByName(name);

        if(existCategory != null){
            String message = "Could not create category. A category with name " + name + " already exists";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
        }else{
            Category newCategory = new Category(name);
            categoryDAO.create(newCategory);
            listCategories("New category created successfully!");
        }
    }


    public void editUser() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));

        Category category = categoryDAO.get(categoryId);
        String editPage = "category_form.jsp";
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);
    }

    public void updateCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String categoryName = request.getParameter("name");

        Category categoryById = categoryDAO.get(categoryId);
        Category categoryByName = categoryDAO.findByName(categoryName);

        if(categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()){
            String message = "Could not update category. Category with name" + categoryName + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
        }else{
            categoryByName.setName(categoryName);
            categoryDAO.update(categoryById);
            String message = "Category has been updated successfully";
            listCategories(message);
        }

    }

    public void deleteCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        categoryDAO.delete(categoryId);
        String message = "Category has been deleted successfully";
        listCategories(message);
    }
}
