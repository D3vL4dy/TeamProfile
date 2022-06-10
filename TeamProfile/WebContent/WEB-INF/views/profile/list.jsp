<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Profile</title>
<style>
	body{
		font-family: Nanum;
	}
	
 	.d1{
		margin: 0 auto;
		width: 100%; 
		max-width: 800px; 
		align-self: center; 
		margin-top: 1px; 
		margin-bottom: 1px;
	}
	
	.photo{
		 display: block; 
		 object-fit: cover; 
		 border-radius: 1px; 
		 pointer-events: auto; 
		 width: 300px; 
		 height: 300px;
		 border-radius: 100%;
		 margin-top: 20px;
	}
	
	.name{
		 width: 100%; 
		 white-space: pre-wrap; 
		 word-break: break-word; 
		 caret-color: rgb(55, 53, 47); 
		 padding: 3px 2px;  
		 font-weight: 600; 
		 font-size: 1.875em; 
		 line-height: 1.3;
	}
	
	.mail{
		 width: 100%; 
		 margin-bottom: 25px; 
		 word-break: break-word; 
		 caret-color: rgb(55, 53, 47); 
		 padding: 3px 2px;
	}
	
	.text{
		width: 100%; 
		white-space: pre-wrap; 
		word-break: break-word; 
		caret-color: rgb(55, 53, 47); 
		padding: 3px 2px;
	}
	
	#p1{
		width: 100%; 
		align-self: center; 
		margin-top: 1px; 
		margin-bottom: 1px;
	}
	.p2{
		display: flex; 
		justify-content: center;
	}
	.img{
		flex-grow: 0; 
		flex-shrink: 0; 
		width: calc(( 100% - 46px)* 0.4375);
	}
	.d2{
		padding-top: 12px; 
		padding-bottom: 12px; 
		flex-grow: 0; 
		flex-shrink: 0; 
		width: calc(( 100% - 46px)* 0.5625);
	}
	.imgend{
		position: relative; 
		width: 50px; 
		flex-grow: 0; 
		flex-shrink: 0; 
		transition: opacity 200ms ease-out 0s; 
		opacity: 0;
	}
	.s{
	 	color: rgb(120, 119, 116); 
	 	fill: rgb(120, 119, 116);
	}
	.d3{
		color: inherit; 
		fill: inherit;
	}

</style>
</head>
<body>
	<div id="p">
		<div class="p2">
			<img src="<%=request.getContextPath() %>/resources/images/people.jpg" alt="../images/people.jpg" style="width: 100%;">
		</div>
	</div>
	<!-- 상단 이미지 -->
	
	<div class="d1">
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/choi.jpg" alt="../images/choi.jpg">
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px;">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false">최 민 규</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀장 / rebone0427@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >앙앙앙~</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >고기 짱 조하~~</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >고기 없인 못살앙~~~</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >정말못살아잉~~~~</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 1끝 -->

	<div class="d1">
		<hr>
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/door.jpg" alt="../images/door.jpg">
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px;">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false">장 문 석</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀원 / cacao621@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >난 낭만을 즐기지...✩</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >불판 위에 구워지는 막창을 보며</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >오늘도 난 군침을 닦는다</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >스윽-</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 2끝 -->
	
	<div class="d1">
		<hr>
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/nani.jpg" alt="../images/nani.jpg">
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px; ">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false">서 난 희</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀원 / tjsksgml123@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >냐냥냐앙~~</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >내 이름은!!!! 나니코★</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >똑순이 집사랍니다~</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >우리 똑순이 저처럼 참 귀엽죠^_^?</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 3끝 -->
	
	<div class="d1">
		<hr>
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/kji.jpg" alt="../images/kji.jpg" >
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px; ">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false" >강 정 인</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀원 / jikang1218@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >힐링을 주는 웃음소리 히힛-</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >언제나 활기찬 그녀  푸항항 ꉂꉂ(ᵔᗜᵔ*)</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >푸들처럼 곱슬머리가 특징인</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >♡♥♡ 저니니 ♥♡♥</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 4끝 -->
	
	<div class="d1">
		<hr>
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/oh.jpg" alt="../images/oh.jpg">
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px; ">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false" >오 지 현</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀원 / ohproji@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >피캇츄~!</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >피-카</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >피카피-카-</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >핏피카츄~!!</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 5끝 -->
	
	<div class="d1">
		<hr>
		<div class="p2">
			<!-- 이미지 -->
			<div class="img">
				<img class="photo" src="<%=request.getContextPath() %>/resources/images/em.jpg" alt="../images/em.jpg">
			</div>
			<!-- 이미지 끝 -->
			<div class="imgend"></div>
			<!-- 소개 -->
			<div class="d2">
				<div style="display: flex; flex-direction: column; padding-left: 30px; ">
					<div style="width: 100%; margin-top: 2em; margin-bottom: 4px; ">
						<div style="display: flex; width: 100%; color: inherit; fill: inherit; ">
							<div class="name" data-content-editable-leaf="true" contenteditable="false">이 종 민</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="mail" data-content-editable-leaf="true" contenteditable="false">
									<span class="s" data-token-index="0">팀원 / em11133@naver.com</span>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >든든할 것 같지만 전혀 든든하지 않은 나</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >믿음직할 것 같지만 전혀 믿음직하지 않은 나</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 1px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >나이가 제일 많을 것 같지만 사실은 막내인 나</div>
							</div>
						</div>
					</div>
					<div style="width: 100%; margin-top: 1px; margin-bottom: 0px; ">
						<div class="d3">
							<div style="display: flex; ">
								<div class="text" data-content-editable-leaf="true" contenteditable="false" >이종민입니다.</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 소개 끝 -->
		</div>
	</div>
	<!-- 6끝 -->
	
</body>
</html>