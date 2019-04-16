[![Build Status](https://travis-ci.org/rookah/DevOps.svg?branch=master)](https://travis-ci.org/rookah/DevOps)
[![Coverage](https://codecov.io/gh/rookah/DevOps/branch/master/graph/badge.svg)](https://codecov.io/gh/rookah/DevOps)

# Data analysis Java library

Our structure : DataFrame
	A DataFrame is a two dimensionnal array where each column is identified by a label,
	and each row is identified by an index. Each column contains data of the same
	type, but rows can have multiple types.

Features :
	- Creation of a DataFrame from a CSV file
	- Creation of a DataFrame from an initialization array
	- 3 methods to display a DataFrame :
		- The full DataFrame
		- The first n rows
		- The last n rows
	- 2 types of selection in a DataFrame :
		- From indexes (rows)
		- From labels (columns)
	- Statistical operations on a DataFrame :
		- Mean over selected columns
		- Maximum over selected columns
		- Minimum over selected columns

# Tools used

Project creation :
	We used Maven to create our Java project, this tool allowing us to perform easily
	JUnit tests.

Continuous integration :
	We used TravisCI to ensure the continous integration of the project.
	On a new push from a contributor, TravisCI compile and runs tests with Maven.
	It also build a docker image of the project, then pushes it on DockerHub using
	the docker_push script from our sources.
	When the build is succesful, the code coverage report is sent to the appropriate
	tool.

Code coverage :
	We chose JaCoCo to analyze the code coverage of our tests. We then analyze the
	report with CodeCov.io, an online code coverage statistic tool.

Docker :
	We used Docker
