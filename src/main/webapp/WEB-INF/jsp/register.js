/**
 * 
 */

var register =
{
	onEdit : function ()
	{
		var form = $( 'domainManager');
		form.action = 'editDomain';
		form.actionType.value = 'edit';
		form.submit();
	},
    onApprove : function()
    {
      var form = $( 'domainManager' );
      form.action = 'approveDomain';
      form.actionType.value = 'approve';
      form.submit();
    },
    onExclude : function()
    {
      var form = $( 'domainManager' );
      form.action = 'excludeDomain';
      form.actionType.value = 'exclude';
      form.submit();
    },
    onDelete : function()
    {
      var form = $( 'domainManager' );
      form.action = 'deleteDomain';
      var ids = form.getInputs( 'checkbox', 'toolIds' ).filter( function( box )
      {
        return box.checked;
      } ).map( function( box )
      {
        return box.value;
      } );

      var confirmMsg = 'Are you sure you want to delete this domain?'
      if ( confirm( confirmMsg ) )
      {
        form.actionType.value = 'delete';
        form.submit();
      }
    }
};