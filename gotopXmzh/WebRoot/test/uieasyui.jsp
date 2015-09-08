<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="/common.jsp"%>
    <title>uieasyui</title>
    
	<style>
	.ui-button { margin-left: -1px; }
	.ui-button-icon-only .ui-button-text { padding: 0.35em; } 
	.ui-autocomplete-input { margin: 0; padding: 0.48em 0 0.47em 0.45em; }
	</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	(function( $ ) {
		$(function() {
			$( "#combobox" ).combobox();
			$( "#toggle" ).click(function() {
				$( "#combobox" ).toggle();
			});
		});
		$.widget( "ui.combobox", {
			_create: function() {
				var self = this,
					select = this.element.hide(),
					selected = select.children( ":selected" ),
					value = selected.val() ? selected.text() : "";
				var input = this.input = $( "<input>" )
					.insertAfter( select )
					.val( value )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: function( request, response ) {
							var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
							response( select.children( "option" ).map(function() {
								var text = $( this ).text();
								if ( this.value && ( !request.term || matcher.test(text) ) )
									return {
										label: text.replace(
											new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" +
												$.ui.autocomplete.escapeRegex(request.term) +
												")(?![^<>]*>)(?![^&;]+;)", "gi"
											), "<strong>$1</strong>" ),
										value: text,
										option: this
									};
							}) );
						},
						select: function( event, ui ) {
							ui.item.option.selected = true;
							self._trigger( "selected", event, {
								item: ui.item.option
							});
						},
						change: function( event, ui ) {
							if ( !ui.item ) {
								var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
									valid = false;
								select.children( "option" ).each(function() {
									if ( $( this ).text().match( matcher ) ) {
										this.selected = valid = true;
										return false;
									}
								});
								if ( !valid ) {
									// remove invalid value, as it didn't match anything
									$( this ).val( "" );
									select.val( "" );
									input.data( "autocomplete" ).term = "";
									return false;
								}
							}
						}
					})
					.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li></li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};

				this.button = $( "<button type='button'>&nbsp;</button>" )
					.attr( "tabIndex", -1 )
					.attr( "title", "Show All Items" )
					.insertAfter( input )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.removeClass( "ui-corner-all" )
					.addClass( "ui-corner-right ui-button-icon" )
					.click(function() {
						// close if already visible
						if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
							input.autocomplete( "close" );
							return;
						}

						// work around a bug (likely same cause as #5265)
						$( this ).blur();

						// pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
						input.focus();
					});
			},

			destroy: function() {
				this.input.remove();
				this.button.remove();
				this.element.show();
				$.Widget.prototype.destroy.call( this );
			}
		});
		
	})( jQuery );

	</script>
  </head>
  
  <body>
		
	<div class="demo">
	
	<div class="ui-widget">
		<label>Your preferred programming language: </label>
		<select id="combobox">
			<option value="">Select one...</option>
			<option value="ActionScript">ActionScript</option>
			<option value="AppleScript">AppleScript</option>
			<option value="Asp">Asp</option>
			<option value="BASIC">BASIC</option>
			<option value="C">C</option>
			<option value="C++">C++</option>
			<option value="Clojure">Clojure</option>
			<option value="COBOL">COBOL</option>
			<option value="ColdFusion">ColdFusion</option>
			<option value="Erlang">Erlang</option>
			<option value="Fortran">Fortran</option>
			<option value="Groovy">Groovy</option>
			<option value="Haskell">Haskell</option>
			<option value="Java">Java</option>
			<option value="JavaScript">JavaScript</option>
			<option value="Lisp">Lisp</option>
			<option value="Perl">Perl</option>
			<option value="PHP">PHP</option>
			<option value="Python">Python</option>
			<option value="Ruby">Ruby</option>
			<option value="Scala">Scala</option>
			<option value="Scheme">Scheme</option>
		</select>
	</div>
	<button id="toggle">Show underlying select</button>
	
	</div><!-- End demo -->
	
	
	
	<div class="demo-description">
	<p>A custom widget built by composition of Autocomplete and Button. You can either type something into the field to get filtered suggestions based on your input, or use the button to get the full list of selections.</p>
	<p>The input is read from an existing select-element for progressive enhancement, passed to Autocomplete with a customized source-option.</p>
	</div><!-- End demo-description -->

  </body>
</html>
