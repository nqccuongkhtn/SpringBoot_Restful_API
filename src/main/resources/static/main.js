var app=angular.module('app',[]);
//send tokenAuthentication
app.run(function($http)
		{
			$http.defaults.headers.common.Authorization="eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjA0MjgyNTgsInVzZXJuYW1lIjoiYWRtaW4ifQ.0fvoLcuXjfK9ENhGylhv2EoefTi1RJknP-8Hbkg_x9Y";
		});
app.controller('EmployeeController',['$scope','$http',function($scope,$http)
	{
		$scope.employees=[];
		$scope.employeeForm={
			empId:1,
			empNo:"",
			empName:""
		}
		//now load the data from the server 
		_refreshEmployeeData();
		// HTTP POST/PUT methods for add/edit employee
		// Call: http://localhost:8080/rest/employees
		$scope.submitEmployee=function()
		{
			var method="";
			var	url="";
			
			if($scope.employeeForm.empId==-1)
				{
					method="post";
					url="/rest/employees";
				}
			else
				{
					method="put";
					url="/rest/employees";
				}
			$http({
					method:method,
					url:url,
					data:angular.toJson($scope.employeeForm),
					headers:{
						'Content-Type':'application/json'
					}
			}).then(_success,_error);
		};
		$scope.createEmployee=function()
		{
			_clearFormData();
		}
		// HTTP DELETE-delete methods for delete employee
		// Call: http://localhost:8080/rest/employees{empId}
		$scope.deleteEmployee=function(employee)
		{
			$http({
					method:'DELETE',
					url: '/rest/employees/'+employee.empId	
			}).then(_success,_error);
		}
		//In case of edit
		$scope.editEmployee=function(employee)
		{
			$scope.employeeForm.empId=employee.empId;
			$scope.employeeForm.empNo=employee.empNo;
			$scope.employeeForm.empName=employee.empName;
		}
		//Private method
		//HTTP GET- get all employees collection
		// Call: http://localhost:8080/rest/employees
		function _refreshEmployeeData()
		{
			$http({
					method:'GET',
					url:'/rest/employees'
			}).then(function(res)
					{//success
						$scope.employees=res.data;
						console.log(res.data);
					}),
					function(res)//error
					{
						console.log("Error: "+res.status + ":" +res.data);
					}
		}
		function _success(res)
		{
			_refreshEmployeeData();
			_clearFormData();
		}
		function _error(res)
		{
			var data=res.data;
			var status=res.status;
			var header	=res.header;
			var config=res.config;
			alert("Error: " + status + ":" + data);
		}
		
		//Clear the form
		function _clearFormData()
		{
			$scope.employeeForm.empId=-1;
			$scope.employeeForm.empNo="";
			$scope.employeeForm.empName="";
		}
	}]);