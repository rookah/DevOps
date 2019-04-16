[![Build Status](https://travis-ci.org/rookah/DevOps.svg?branch=master)](https://travis-ci.org/rookah/DevOps)
[![Coverage](https://codecov.io/gh/rookah/DevOps/branch/master/graph/badge.svg)](https://codecov.io/gh/rookah/DevOps)

# Data analysis Java library

DataFrame :
	A DataFrame is a two dimensionnal array where each column is identified by a label,
	and each row is identified by an index. All columns contain data of the same
	type, but rows can have different types on their fields.

Features :
	- Creation of a DataFrame from a CSV file
	- Creation of a DataFrame from an initialization array
	- 3 methods to display a DataFrame :
		- The full DataFrame (toString())
		- The first n rows
		- The last n rows
	- 2 types of selection in a DataFrame (return new dataframes):
		- From indexes (rows)
		- From labels (columns)
	- Statistical operations on a DataFrame :
		- Mean over selected columns
		- Maximum on selected columns
		- Minimum on selected columns

# Tools used

Project creation :
	We use Maven as our Java build system. This tool allows us to perform tests
	easily using JUnit integration.

Continuous integration :
	We use TravisCI to ensure the continous integration of the project.
	On a new push from a contributor, TravisCI compiles and runs tests with Maven.
	It also builds a docker image of the project and automatically pushes it on our DockerHub repo using
	the docker_push script from our sources.
	When the build is succesful, the code coverage report is sent to the appropriate
	tool (see next section).

Code coverage :
	We use JaCoCo to analyze the code coverage of our project. This report is reported (by Travis) and analyzed
	in CodeCov.io, an online code coverage statistic tool. A code coverage badge is shown on the repository's page on github,
	showcasing the percentage of code currently covered.

Docker :
	Everytime the project is built by travis, a docker image is automatically created and pushed to our dockerhub page.
	This image automatically compiles the project, and runs all the tests.

# Usage

	All the public methods inside the DataFrame.java class are usable by the user.
	- mean() computes the mean by column, and returns the result as a dataframe
	- max() and min() compute the global maximum and minimum of a specified dataframe, and return it as a float
	- mean(ArrayList<String>) computes the mean by column on a selection of columns
	- max(ArrayList<String>) & min(ArrayList<String>) compute the max & min on a selection of columns

	Please be aware of the following pre-conditions:
	- If the dataframe is empty, max() and min() return 0.0
	- The behavior of mean(), max() and min() is unspecified if the selected columns do not contain values that can't be represented by floats
