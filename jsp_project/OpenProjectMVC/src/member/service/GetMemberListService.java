package member.service;



public class GetMemberListService {
	

		private GetMemberListService() {}

		private static GetMemberListService service = new GetMemberListService();

		public static GetMemberListService getInstance() {

			return service;
		}
		
		
	
}

