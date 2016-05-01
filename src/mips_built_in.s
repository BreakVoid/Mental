	.text
_func_____built_in_toString:     # t0 head of buffer
	li $v0, 9
	li $a0, 32
	syscall
	move $t0, $v0
	lw $t1, -4($sp)               # t1 the number need to convert
	slt $t2, $t1, $zero          # t2 the sign of the number
	bnez $t2, toString_int_less_than_zero
toString_neg_parameter:
	add $t3, $t0, 30
	li $t5, 0
	sb $t5, 1($t3)               # set last char as 0
	li $t6, 0
again:
	rem $t4, $t1, 10             # t1 mod 10
	add $t4, $t4, 48             # convert to ascii
	sb $t4, 0($t3)               # save to pointer
	div $t1, $t1, 10             # t1 = t1 / 10
	sub $t3, $t3, 1              # pointer--
	add $t6, $t6, 1
	bnez $t1, again
	bnez $t2, toString_append_minus
	add $t3, $t3, 1
	beqz $t2, toString_convert_end
toString_append_minus:
	li $t5, 45
	sb $t5, 0($t3)
toString_convert_end:
	sw $t6, 0($t0)
	add $t0, $t0, 4
	move $v0, $t0
toString_copy_data:
	lb $t8, 0($t3)
	beqz $t8, toString_copy_over
	sb $t8, 0($t0)
	add $t0, $t0, 1
	add $t3, $t3, 1
	b toString_copy_data
toString_copy_over:
	jr $ra
toString_int_less_than_zero:
	neg $t1, $t1
	b toString_neg_parameter
