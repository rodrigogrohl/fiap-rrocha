//verifica a compatibilidade com browsers 
window.indexedDB = window.indexedDB 
	|| window.mozIndexedDB 
	|| window.webkitIndexedDB 
	|| window.msIndexedDB;

window.IDBTransaction = window.IDBTransaction 
	|| window.webkitIDBTransaction 
	|| window.mozIDBTransaction 
	|| window.msIDBTransaction;

window.IDBKeyRange = window.IDBKeyRange 
	|| window.webkitIDBKeyRange 
	|| window.mozIDBKeyRange 
	|| window.msIDBKeyRange;

var request, db;

if (!window.indexedDB) { 

	window.alert("Seu navegador não suporta o recurso IndexedDB.")

} else { 
	request = window.indexedDB.open("DBCandidatos", 1); 
	request.onerror = function (event) { 
		$("#mensagemdb").html("Erro ao abrir o banco de dados"); 
		$("#btnEnviar").prop("disabled", true); 
	} 
	request.onupgradeneeded = function (event) { 
		$("#mensagemdb").html("Banco de dados preparado para uso");
		db = event.target.result; 
		var objectStore = db.createObjectStore("candidatos", { keyPath: "email" }); 
	}; 
	request.onsuccess = function (event) { 
		$("#mensagemdb").html("Banco de dados aberto com sucesso");
		db = event.target.result;
	} 
}

// evento para incluir um novo candidato 
$("#btnEnviar").click(function () { 
	var nome = $("#nome").val(); 
	var datanasc = $("#data").val(); 
	var telefone = $("#telefone").val(); 
	var email = $("#email").val(); 
	var vaga = $("#vaga").val();
	
	var transaction = db.transaction(["candidatos"], "readwrite");
	
	transaction.oncomplete = function (event) {
		$(location).attr("href", "/paginas/registroOk.html"); 
	}; 
	
	transaction.onerror = function (event) { 
		alert("Ocorreu um erro ao incluir o registro");
	}; 
	
	var objStore = transaction.objectStore("candidatos"); 
	objStore.add({ email: email, nome: nome, data: datanasc, telefone: telefone, vaga: vaga }); 
});
	
// evento para listar os candidatos, adicionando-os em uma lista <li>
$("#btnListar").click(function () { 
	var request = db.transaction(["candidatos"], "readonly").objectStore("candidatos");
	request.openCursor().onsuccess = function (event) { 
		var cursor = event.target.result; 
		if (cursor) { 
			$("#listaCandidatos").append("<li>" + cursor.value.nome + "</li>"); 
			cursor.continue();
		} 
	}; 
});
