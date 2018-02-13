package com.revature.screens;

/*
 * For every transaction, a screen is created for the execution of that
 * transaction. The screen is displayed by calling the prompt() method 
 */

public interface Screen {
	Screen prompt();
}
