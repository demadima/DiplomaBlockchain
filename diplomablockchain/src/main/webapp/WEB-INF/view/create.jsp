<%@include file="/theme/template-part/header.jsp"%>

<section class="banner">
	<%@include file="/theme/template-part/login_banner.jsp"%>
</section>

    <section class="contacts-form feedback scroll">
        <div class="container">
            <div class="row">
                <div class="col-12">
                        <h2 class="feedback__title section__title">
                            Join to us
                        </h2>
                    <div class="contacts-form__description content scroll">
                        Create a new block in our system
                    </div>
                    <%@include file="/theme/template-part/create_form.jsp"%>
                </div>
            </div>
        </div>
    </section>
    
    <section class="contact-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-12">
    				<div class="contacts-section__row">
    					<div class="contacts-section__item">
    						<img src="/theme/images/contacts-phone.png"	alt="Contact phone">
    							<div class="contacts-section__wrapper">
    								<h5 class="contacts-section__subtitle">
    									PHONE
    								</h5>
    								<a href="tel:380638612504" class="contacts-section__link">
    									+38 063 841 25 05
    								</a>
    							</div>
    						</div>
    					<div class="contacts-section__item">
    						<img src="/theme/images/contacts-mail.png" alt="Contact mail">
    							<div class="contacts-section__wrapper">
    								<h5 class="contacts-section__subtitle">
    									E-MAIL
    								</h5>
    								<a href="mailto:cunade@ukr.net" class="contacts-section__link">
    									testmail@gmail.com
    								</a>
    							</div>
    						</div>
    					<div class="contacts-section__item">
    						<img src="/theme/images/contacts-location.png" alt="Contact location">
    							<div class="contacts-section__wrapper">
    								<h5 class="contacts-section__subtitle">
    									REMINDER
    								</h5>
    								<span class="contacts-section__address">
    									ATTENTION! Do not forget, after adding new data, you cannot change them anymore!!!
    								</span>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</section>
    	
    	<div style="height: 10px;"></div>

        <%@include file="/theme/template-part/footer.jsp"%>