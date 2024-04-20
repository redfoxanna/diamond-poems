<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<c:import url="header.jsp" />
<body>
<!-- ======= F.A.Q Section ======= -->
<section id="faq" class="faq section-bg">
    <div class="container" data-aos="fade-up">
        <div class="section-title">
            <h2>F.A.Q</h2>
            <p>Frequently Asked Questions</p>
        </div>
        <ul class="faq-list" data-aos="fade-up" data-aos-delay="100">
            <li>
                <div data-toggle="collapse" data-target="#faq1" class="collapsed question"> How do I write a Diamond Poem? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
                <div id="faq1" class="collapse" data-parent=".faq-list">
                    <p>
                        Here's the basic structure:<br/><br/>

                        Line 1: One word<br/>
                        Line 2: Two words<br/>
                        Line 3: Three words<br/>
                        Line 4: Four words<br/>
                        Line 5: Three words<br/>
                        Line 6: Two words<br/>
                        Line 7: One word<br/><br/>

                        When written out with appropriate line breaks, it forms a diamond shape.
                    </p>
                </div>
            </li>
            <li>
                <div data-toggle="collapse" data-target="#faq2" class="collapsed question"> What is Optical Character Recognition (OCR)? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
                <div id="faq2" class="collapse" data-parent=".faq-list">
                    <p>
                        Optical Character Recognition (OCR) is a technology that let you convert different types of documents,
                        such as scanned paper documents, PDF files, or images, into editable and searchable data.<br/><br/>

                        This application uses AWS Textract which is a machine learning-based service
                        that automatically extracts text, handwriting, forms, and tables from scanned documents or images.
                    </p>
                </div>
            </li>
            <li>
                <div data-toggle="collapse" data-target="#faq3" class="collapsed question">How large of a file can I upload? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
                <div id="faq3" class="collapse" data-parent=".faq-list">
                    <p>
                        File size must be 5MB or smaller.
                    </p>
                </div>
            </li>
            <li>
                <div data-toggle="collapse" data-target="#faq4" class="collapsed question">How can I contribute to the archives? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
                <div id="faq4" class="collapse" data-parent=".faq-list">
                    <p>
                        You must create a user account to add to the archives. You are always welcome to view the archives without creating an account.
                    </p>
                </div>
            </li>
            <!-- Add more FAQ items as needed -->
        </ul>
    </div>
</section><!-- End F.A.Q Section -->
</body>
</html>
