$('document').ready(function(){
	
    $('.input-chamada').bootstrapToggle({
        on: 'Presente',
        off: 'Nao presente'
      });

      $('.input-chamada').change(function() {
        let id_aluno = $(this).attr('data-aluno');
        console.log(id_aluno);
        let presenca = 0;
        
        if($(this).is(':checked')){
          console.log('inserir presente');
          presenca = 1;
        }else{
          console.log('inserir falta');
          presenca = 2;
        }
        
            $.ajax({
            	 url : "/fazerChamada",
				dataType: 'json',
				type: 'post',
				data: {id_aluno: id_aluno, presenca: presenca}
			})
			.done(function (arrDados) {
				console.log(arrDados);
			});
        

  	 });
});