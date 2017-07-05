
var app= angular.module("myBanqueApp", [])
app.controller("myBanqueController", function($scope, $http){
	
	$scope.compte=null;
	$scope.codeCompte=null;
	$scope.operation={type:"versement", montant:0, cpte2:null}
	$scope.pageOperations=[];
	$scope.pageCourante=0;
	$scope.pageSize=3;
	$scope.pages=0;
	$scope.errorMessage=null;
	
	
	$scope.chargerCompte=function(){
		$scope.pageCourante=0;
		$scope.errorMessage=null;
		$http.get("/comptes/" + $scope.codeCompte)
		.success(function(data){
			$scope.compte=data;
			$scope.chargerOperation();
							 })
		 .error(function(data){
			$scope.errorMessage=data.message;
			$scope.compte=null;
							 });
									};
	$scope.chargerOperation = function(){
		
		$http.get("/operations?codeCompte=" + $scope.codeCompte + 
				"&page=" + $scope.pageCourante+
				"&size=" + $scope.pageSize)
				
		.success(function(data){
			$scope.pageOperations=data;
			$scope.pages=new Array(data.totalPages);
							 });
		
	};
	$scope.goToPage=function(p){
		$scope.pageCourante=p;
		$scope.chargerOperation();
	}

$scope.saveOperation=function(){
		
	var params="";
	if($scope.operation.type=='virement'){
		params="cpte1=" + $scope.codeCompte+"&cpte2="+$scope.operation.cpte2+"&montant=" + $scope.operation.montant+"&codeEmp=1";
		
	}
	else {
		params="code=" + $scope.codeCompte+"&montant=" + $scope.operation.montant+"&codeEmp=1";
	}
	
		$http({
				method : 'PUT',
				url: $scope.operation.type,
				data:params,
				headers:{'content-Type' : 'application/x-www-form-urlencoded'}
				})
				.success(function(data){
					$scope.chargerCompte();
					//$scope.loadOperations();
									 });
				};
														});