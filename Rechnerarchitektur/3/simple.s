	.data
str1:	.ascii "Geben Sie beliebig viele Zahlen zwischen 1 und 99 ein.\n"	
	.asciiz "Eingabe von 0 beendet die Eingabe und gibt das Ergebnis aus.\n"
askstr:	.asciiz "\n?-> "
errstr:	.asciiz "Sie duerfen nur Zahlen zwischen 1 und 99 eingeben.\n"
answstr:.asciiz "Das Ergebnis lautet: "
str2:	.asciiz "\n\n"

	.text
main:	li	$s0, 0
	li	$s1, 0

	li	$v0, 4		
	la	$a0, str1       
	syscall
	
loop:	li	$v0, 4		
	la	$a0, askstr     
	syscall

	li	$v0, 5		
	syscall
	li	$t2, 99
	bgt	$v0, $t2, error
	li	$t2, 0
	blt	$v0, $t2, error
	beqz	$v0, exit
	addi	$s1, $s1, 1
	mul	$t2, $v0, $v0
	mul	$t2, $t2, $s1
	add	$s0, $s0, $t2

	j	loop

error:	li	$v0, 4
	la	$a0, errstr	
	syscall
	j	loop

exit:	li	$v0, 4		
	la	$a0, answstr    
	syscall

	li	$v0, 1
	move	$a0, $s0
	syscall

	li	$v0, 4		
	la	$a0, str2       
	syscall
	
	li	$v0, 10
	syscall