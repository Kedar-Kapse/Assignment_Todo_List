<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #fff; 
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: left;
            color: #fff; 
            background-color: gray; 
            padding: 6px;
            margin-bottom: 20px;
            width: 100%;
            box-sizing: border-box;
        }

        .top-button {
            position: fixed;
            top: 27px;
            right: 10px;
            padding: 10px;
            background-color: #4caf50; 
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .top-button:hover {
            background-color: #45a049;
        }

        .list-container {
            max-width: 800px;
            margin: 0 auto;
            display: flex;
            justify-content: space-around;
        }

        .list {
            list-style-type: none;
            padding: 0;
            margin: 0;
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            padding: 10px;
            width: 300px;
            position: relative;
        }

        .list-item {
            margin-bottom: 10px;
            padding: 10px;
            background-color: #fff;
            border: 1px solid #ddd;
            cursor: move;
        }

        .delete-button {
            position: absolute;
            top: 5px;
            right: 5px;
            background-color: #f44336;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <button class="top-button">Top Button</button>
    <h1>Welcome Guys</h1>

    <div class="list-container">
        <div class="list" id="list1" ondrop="drop(event)" ondragover="allowDrop(event)">
            <h2>List 1</h2>
            <li class="list-item" draggable="true" ondragstart="drag(event)">List Item 1</li>
            <li class="list-item" draggable="true" ondragstart="drag(event)">List Item 2</li>
            <li class="list-item" draggable="true" ondragstart="drag(event)">List Item 3</li>
            <button class="delete-button" onclick="deleteList('list1')">Delete</button>
        </div>
        
        <div class="list" id="list2" ondrop="drop(event)" ondragover="allowDrop(event)">
            <h2>List 2</h2>
            <!-- You can add more items here or leave it empty for the start -->
            <button class="delete-button" onclick="deleteList('list2')">Delete</button>
        </div>

        <div class="list" id="list3" ondrop="drop(event)" ondragover="allowDrop(event)">
            <h2>List 3</h2>
            <!-- You can add more items here or leave it empty for the start -->
            <button class="delete-button" onclick="deleteList('list3')">Delete</button>
        </div>
    </div>

    <div>
        <label for="newListName">New List Name: </label>
        <input type="text" id="newListName">
        <button onclick="createNewList()">Create New List</button>
    </div>

    <script>
        var lists = ['list1', 'list2', 'list3'];

        function allowDrop(event) {
            event.preventDefault();
        }

        function drag(event) {
            event.dataTransfer.setData("text", event.target.innerText);
        }

        function drop(event) {
            event.preventDefault();
            var data = event.dataTransfer.getData("text");
            var newItem = document.createElement("li");
            newItem.className = "list-item";
            newItem.appendChild(document.createTextNode(data));

            var destinationList = event.target.tagName === "DIV" ? event.target : event.target.parentElement;

            destinationList.appendChild(newItem);
        }

        function createNewList() {
            var newListName = document.getElementById("newListName").value;
            if (newListName.trim() !== "") {
                var newListId = 'list' + (lists.length + 1);
                var newList = document.createElement("div");
                newList.className = "list";
                newList.id = newListId;
                newList.setAttribute("ondrop", "drop(event)");
                newList.setAttribute("ondragover", "allowDrop(event)");

                var newListHeader = document.createElement("h2");
                newListHeader.appendChild(document.createTextNode(newListName));
                newList.appendChild(newListHeader);

                var deleteButton = document.createElement("button");
                deleteButton.className = "delete-button";
                deleteButton.appendChild(document.createTextNode("Delete"));
                deleteButton.onclick = function() { deleteList(newListId) };
                newList.appendChild(deleteButton);

                document.querySelector('.list-container').appendChild(newList);
                lists.push(newListId);
            }
        }

        function deleteList(listId) {
            var listElement = document.getElementById(listId);
            if (listElement) {
                listElement.parentNode.removeChild(listElement);
                lists = lists.filter(function(item) {
                    return item !== listId;
                });
            }
        }
    </script>
</body>
</html>