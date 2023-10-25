---
  layout: default.md
    title: "User Guide"
    pageNav: 3
---

# **TASsistant User Guide**

TASsistant is a desktop app for Teaching Assistants (TAs) in NUS to track information about the students and professors
involved in tutoring. It is optimised for users that have experience with a Command Line Interface (CLI) and aims to be
able to handle contact organisation faster than GUI apps if the user can type quickly.

<h2>Table of Contents</h2>

- **[Introduction](#TASsistant User Guide)**
- **[About](#setting-up-getting-started)**
- **[Quick Start](#quick-start)**
- **[Features](#features)**
- **[List of Features](#command-summary)**
- **[Glossary](#glossary)**
- **[FAQ](#faq)**

--------------------------------------------------------------------------------------------------------------------

## **Quick start**

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `TASsistant.jar` from [here]().

3. Copy the file to the folder you want to use as the _home folder_ for your TASsistant.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar TASsistant.jar` command to run the application.<br>

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all contacts.

    * `delete 3` : Deletes the 3rd contact shown in the current list.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## **Features**

<box type="info" seamless>

**Notes about the command format:**

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a person: `add`

Adds a person to TASsistant.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS s/STUDENT_NUMBER [t/TAG]…​`

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`
* `add n/Johann Petrovich s/A0232865J`

### Listing all persons : `list`

Shows a list of all persons in TASsistant.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/STUDENT_NUMBER] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
*  `edit 3 s/A0514624K` Edits the student number of the 2nd person to be 'A0514624K'
### Locating persons by name: `find`

### Deleting a person : `delete`

Deletes the specified person from TASsistant.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in TASsistant.

### Search : `search`

Lists out all students with the given condition.

Format: `search CONDITION1, CONDITION2, …`

* Condition is given in the format keyword: value.
* Accepted condition keywords are module, classNum, and studentName.
* Unrecognised keywords cause this method to fail.

Examples:
* `search module: CS2103T` returns all students in the module CS2103T
* `search classNum: T03` returns all students in the class T03
* `search studentName:` John Doe' returns all students with the name John Doe

### Clearing all entries : `clear`

Clears all entries from TASsistant.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

TASsistant data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TASsistant data are saved automatically as a JSON file `[JAR file location]/data/TASsistant.json`. Advanced users are welcome to update data directly by editing that data file.

**Caution:**
If your changes to the data file makes its format invalid, TASsistant will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</box>

### Archiving data files `[coming in v2.0]`


### Adds a module to TASsistant: `addModule`
Adds the module to TASsistant, displaying it on the GUI.
The module name must consist of only alphanumeric characters, no shorter than 5 characters.
Will give an error message if the module already exists in TASsistant,
further prompts are given for incorrect inputs.

Format: `addModule m/MODULE_NAME`

Example: `addModule m/CS2100`

### Deletes a module from TASsistant: `deleteModule`
Deletes the module from TASsistant and the GUI will change to reflect this.
The index refers to the position of the module displayed on the GUI.
Will give an error message if the module does not exist in TASsistant,
further prompts are given for incorrect inputs.

Format: `deleteModule INDEX`

Example: `deleteModule 1`

### Editing a Student's details: `editDetail` '[coming soon]'

Allows the user to change less important details such as the telegram handle and
email to new values. For this version the details are limited to `/TELEGRAM` and `/EMAIL`.

Format: `editDetail INDEX /DETAIL NEW_DETAIL`

Example: `editDetail 1 /TELEGRAM @johannpetrovich`

### Adding a user to a given module: `addToModule`

Adds the user at the specified INDEX displayed on the GUI to a given module.
The index refers to the index number shown in the displayed user list.
Users are added with “none” status. The index must be a positive integer.
Will give an error message if the module given has not been made.

Format: `addToModule INDEX [m/MODULE]`

Example: `addToModule 2 m/CS2103T` adds the person who is second from the top in the current list to the module
CS2103T, if the module CS2103T exists.

### Removes a user from a given module: `removeFromModule`

Removes the user at the specified INDEX displayed on the GUI from a given module.
The index refers to the index number shown in the displayed user list. The index must be a positive integer.
Will give an error message if the module given has not been made or if the user is not part of the given module.

Format: `removeFromModule INDEX [m/MODULE]`

Example: `removeFromModule 2 m/CS2103T` removes the person who is second from the top in the current list from the module
CS2103T, if the module CS2103T exists and the person who is second from the top is part of the module CS2103T.

### Adds a tutorial to a given module: `addTutorial`

Adds a tutorial with a specific tutorial name to a given module. Different modules can have different tutorials 
with the same name. Will give an error message if the module does not exist or a tutorial with the same name has already
been made for the module.

Format: `addTutorial [m/MODULE_NAME] [tn/TUTORIAL_NAME] [tt/TUTORIAL_TIME]`

Example: `addTutorial m/CS2103T tn/T12 tt/Mon 6pm` adds a tutorial with name T12 and time "Mon 6pm" belonging to module
CS2103T, if module CS2103T exists.

### Removes a tutorial from a given module: `removeTutorial`

Removes a tutorial with a specific tutorial name to a given module.
Will give an error message if the module given has not been made, or if the tutorial does not exist.

Format: `removeTutorial [tn/TUTORIAL_NAME] [m/MODULE_NAME]`

Example: `removeTutorial c12 CS2103T` removes a tutorial with name T12 and time "Mon 6pm" belonging to module CS2103T,
if module CS2103T exists and the tutorial already exists.

### Adds a student to stated Tutorial: `addToTutorial`

Add a new student to the stated tutorial’s student list. Fails if the index is not valid.
Fails and gives an error message if the student already has a tutorial.

Format: `addToTutorial INDEX [m/MODULE_NAME] [tn/TUTORIAL_NAME]`

Example: `addToTutorial 1 m/CS2103T tn/T11`

### Removes a student from stated Tutorial: `removeFromTutorial`

Removes a student from the stated tutorial’s student list. Fails if the index is not valid.

Format: `removeFromTutorial INDEX [m/MODULE_NAME] [tn/TUTORIAL_NAME]`

Example: `removeFromTutorial 1 m/CS2103T tn/T11`

### Edit the details of the stated Tutorial: `editTutorial`

Edit the name and/or the time of the stated Tutorial.
Fails if NEW_NAME or NEW_TIME is in invalid format.

Format: `editTutorial INDEX [tn/NEW_NAME] [tt/NEW_TIME]`

Example: `editTutorial 1 tn/T11 tt/Mon`

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. To resolve this, delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                 | Format, Examples                                                                                                                                                      |
|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**                | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **Clear**              | `clear`                                                                                                                                                               |
| **Delete**             | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                   |
| **Edit**               | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                           |
| **Find**               | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                                                            |
| **List**               | `list`                                                                                                                                                                |
| **Search**             | `search CONDITION1, CONDITION2`<br> e.g., `search module: CS2103T`                                                                                                    |
| **Help**               | `help`                                                                                                                                                                |
| **addModule**          | `addModule m/MODULE_NAME` <br> e.g., `addModule m/CS2100`                                                                                                             |
| **deleteModule**       | `deleteModule INDEX` <br> e.g., `deleteModule 1`                                                                                                                      |
| **addToModule**        | `addToModule INDEX MODULE` <br> e.g., `addToModule 2 CS2103T`                                                                                                         |
| **removeFromModule**   | `removeFromModule INDEX MODULE` <br> e.g., `removeFromModule 2 CS2103T`                                                                                               |
| **addTutorial**        | `addTutorial TUTORIALNAME MODULE` <br> e.g., `addTutorial c12 CS2103T`                                                                                                |
| **removeTutorial**     | `removeTutorial TUTORIALNAME MODULE` <br> e.g., `removeTutorial c12 CS2103T`                                                                                          |
| **changeStatus**       | `changeStatus INDEX MODULE (LETTER: p/t/s/n)` <br> e.g., `changeStatus 2 CS2103T t`                                                                                   |
| **addToTutorial**      | `addToTutorial INDEX [m/MODULE_NAME] [tn/TUTORIAL_NAME]` <br> e.g., `addToTutorial 1 m/CS2103T tn/T11`                                                                |
| **removeFromTutorial** | `removeFromTutorial INDEX [m/MODULE_NAME] [tn/TUTORIAL_NAME]` <br> e.g., `removeFromTutorial 1 m/CS2103T tn/T11`                                                      |
| **editTutorial**       | `editTutorial INDEX [tn/NEW_NAME] [tt/NEW_TIME]` <br> e.g., `editTutorial 1 tn/T11 tt/Mon`                                                                            |

--------------------------------------------------------------------------------------------------------------------

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Teaching Assistant (TA)**: A non-professor tutor which helps the professors of a module by teaching one or more classes.
* **Module**: A unit of study in a specific field set by NUS, such as CS2103T focusing on Software Engineering.
* **Class**: Lessons that are part of a module. Includes laboratries, recitations, tutorials and any form of lesson that includes a TA.

--------------------------------------------------------------------------------------------------------------------

## **FAQ**

**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app on the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous UniNurse home folder.

--------------------------------------------------------------------------------------------------------------------
