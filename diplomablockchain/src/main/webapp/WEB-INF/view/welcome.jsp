

<%@include file="/theme/template-part/header.jsp"%>

<section class="banner">
	<%@include file="/theme/template-part/top_banner.jsp"%>
</section>

<section class="info">
	<div class="container-fluid">
		<div class="row scroll">
			<div class="col-lg-5">
				<div class="info__content">
					<h2 class="info__title section__title">Our user's informations
					</h2>
					<div class="info__description content">Here you can see a
						different information about our users. By using right slider you
						can discover some useful data.</div>
				</div>
			</div>
			<div id="front_slider" class="col-lg-7 p-0" style="display: none">
				

						<c:forEach var="block" items="${blocks}">
							<div class="card border-primary  mb-3" style="width: 45rem;">
								<div class="card-header bg-primary text-white border-primary">Info
									about NAME SURNAME</div>
								<div class="card-body">
									<div class="row">
										<div class="col-sm">Full name: ${block.name} ${block.surname}</div>
										<div class="col-sm">Mark: ${block.mark}</div>
										<div class="col-sm">Mark letter: ${block.markl}</div>
									</div>
								</div>
							</div>
						</c:forEach>
						
				
			</div>
		</div>
	</div>
</section>



<%@include file="/theme/template-part/footer.jsp"%>