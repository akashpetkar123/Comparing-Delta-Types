# Comparing-Delta-Types
Usecase was is to compare the delta types present in the environments

When account goes from lower chart to directly higher chart version (ex:- 20.12 to 22.01) then there can be possibility of missing nodetypes, datatypes, interfacetypes etc which can lead to corrupt the data and enviroment
Note:- Here environment = K8S cluster, types such as nodetypes, datatypes, interfacetypes etc might be missing in the env due to which some functionality may not work, 
20.12 to 22.01 it means every month new release version is released.

Solution:- Was to compare the types present in lower enviroment and higher enviroment (20.12 to 22.01) so we can find the delta and load the missing types in the enviroments.
At first i solved the problem manually by comparing the missing types, but later we can do this in a automated way.
So i created a program and convert into a jar, so it can be run anywhere.

Attached is the source code and sample files to compare.

Steps:-
1) Select the file 1 in the File1 FileChooser option, it will show you the path of the file 1 (Ex:- 1.txt)
2) Select the file 2 in the File2 FileChooser option, it will show you the path of the file 2 (Ex:- 2.txt)
3) Press the button Click, a tab will be displayed with the delta types which are missing

Note:- we can take files from the environment and compare it one by one only.
